package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class tekPredicate {

  Logger logger = LoggerFactory.getLogger(tekPredicate.class);

  private tekDatePath tekDatePath;

  private tekNumberPath tekNumberPath;

  @Autowired
  public void setTekDatePath(tekDatePath tekDatePath) {
    this.tekDatePath = tekDatePath;
  }

  @Autowired
  public void setTekNumberPath(tekNumberPath tekNumberPath) {
    this.tekNumberPath = tekNumberPath;
  }

  public tekPredicate() {}

  public BooleanExpression getPredicate(PathBuilder<?> entityPath, SearchCriteria criteria) {

    logger.debug("Inside getPredicate method");
    logger.debug("criteria: " + criteria.toString());

    final boolean startWithAsterisk;
    final boolean endWithAsterisk;

    logger.debug("criteria  - prefix: " + criteria.getPrefix());
    logger.debug("criteria  - value: " + criteria.getValue());
    logger.debug("criteria  - suffix: " + criteria.getSuffix());

    startWithAsterisk =
        criteria.getPrefix() != null
            && criteria.getPrefix().contains("*");
    endWithAsterisk =
        criteria.getSuffix() != null
            && criteria.getSuffix().contains("*");

    logger.debug("startWithAsterisk: " + startWithAsterisk);
    logger.debug("endWithAsterisk: " + endWithAsterisk);

    String op = getSimpleOperation(criteria.getOperation().charAt(0));

    logger.debug("SearchOperation: " + op);

    logger.debug("keyType: " + criteria.getKeyType());

    // For numeric search
    if (criteria.getKeyType().equals("-")
        || criteria.getKeyType().equals("[")
        || criteria.getKeyType().equals("}")
        || criteria.getKeyType().equals("{")) {
      logger.debug("Get boolean expression for a numeric search");
      return tekNumberPath.getNumberPath(entityPath, op, criteria);
    }

    // For Date search
    if (criteria.getKeyType().equals("!")
        || criteria.getKeyType().equals(".")
        || criteria.getKeyType().equals("|")
        || criteria.getKeyType().equals("@")) {
      logger.debug("Get boolean expression for a date or time search");
      return tekDatePath.getDatePath(entityPath, op, criteria);
    }

    switch (criteria.getKeyType()) {
      case "~":
        logger.debug("Search for UUID");

        final ComparablePath<UUID> path = entityPath.getComparable(criteria.getKey(), UUID.class);

        return op.equals("EQUALITY")
            ? path.eq(UUID.fromString(criteria.getValue().toString()))
            : path.eq(UUID.fromString(criteria.getValue().toString())).not();

      case "_":
        logger.debug("Search for Boolean");

        final BooleanPath BooleanPath = entityPath.getBoolean(criteria.getKey());
        final Boolean valueBoolean = Boolean.parseBoolean(criteria.getValue().toString());
        return BooleanPath.eq(valueBoolean);

      case "*":
        logger.debug("Search for String");

        String op2;
        op2 = this.getComparatorString(startWithAsterisk, endWithAsterisk);

        final boolean ignoreCase = criteria.isIgnoreCase();
        final StringPath StringPath = entityPath.getString(criteria.getKey());

        switch (op2) {
          case "LIKE":
            logger.debug("LIKE");

            if (op.equals("EQUALITY")) {
              logger.debug("POSITIVE");
              return ignoreCase
                  ? StringPath.likeIgnoreCase(criteria.getValue().toString())
                  : StringPath.like(criteria.getValue().toString());
            }

            if (op.equals("NEGATION")) {
              logger.debug("NEGATION");
              return ignoreCase
                  ? StringPath.likeIgnoreCase(criteria.getValue().toString()).not()
                  : StringPath.like(criteria.getValue().toString()).not();
            }

          case "CONTAINS":
            logger.debug("CONTAINS");

            if (op.equals("EQUALITY")) {
              logger.debug("POSITIVE");
              return ignoreCase
                  ? StringPath.containsIgnoreCase(criteria.getValue().toString())
                  : StringPath.contains(criteria.getValue().toString());
            }

            if (op.equals("NEGATION")) {
              logger.debug("NEGATION");
              return ignoreCase
                  ? StringPath.containsIgnoreCase(criteria.getValue().toString()).not()
                  : StringPath.contains(criteria.getValue().toString()).not();
            }

          case "STARTS_WITH":
            logger.debug("STARTS_WITH");

            if (op.equals("EQUALITY")) {
              logger.debug("POSITIVE");
              return ignoreCase
                  ? StringPath.startsWithIgnoreCase(criteria.getValue().toString())
                  : StringPath.startsWith(criteria.getValue().toString());
            }

            if (op.equals("NEGATION")) {
              logger.debug("NEGATION");
              return ignoreCase
                  ? StringPath.startsWithIgnoreCase(criteria.getValue().toString()).not()
                  : StringPath.startsWith(criteria.getValue().toString()).not();
            }

          case "ENDS_WITH":
            logger.debug("ENDS_WITH");

            if (op.equals("EQUALITY")) {
              logger.debug("POSITIVE");
              return ignoreCase
                  ? StringPath.endsWithIgnoreCase(criteria.getValue().toString())
                  : StringPath.endsWith(criteria.getValue().toString());
            }

            if (op.equals("NEGATION")) {
              logger.debug("NEGATION");
              return ignoreCase
                  ? StringPath.endsWithIgnoreCase(criteria.getValue().toString()).not()
                  : StringPath.endsWith(criteria.getValue().toString()).not();
            }

          case "EQUAL":
            logger.debug("EQUAL");

            if (op.equals("EQUALITY")) {
              logger.debug("POSITIVE");
              return ignoreCase
                  ? StringPath.equalsIgnoreCase(criteria.getValue().toString())
                  : StringPath.eq(criteria.getValue().toString());
            }

            if (op.equals("NEGATION")) {
              logger.debug("NEGATION");
              return ignoreCase
                  ? StringPath.equalsIgnoreCase(criteria.getValue().toString()).not()
                  : StringPath.eq(criteria.getValue().toString()).not();
            }
        }
    }

    logger.debug("It didn't find any case");

    return null;
  }


  public static String getSimpleOperation(final char input) {
    switch (input) {
      case '!':
        return "NEGATION";
      case '>':
        return "GREATER_THAN";
      case '<':
        return "LESS_THAN";
      case '~':
        return "LIKE";
      default:
        return "EQUALITY"; // The idea is to use ":" for "EQUALITY"
    }
  }

  private String getComparatorString(Boolean startWithAsterisk, Boolean endWithAsterisk) {

    if (startWithAsterisk.equals(true) && endWithAsterisk.equals(true)) {
      logger.debug("CONTAINS");
      return "CONTAINS";
    } else if (startWithAsterisk.equals(true)) {
      logger.debug("ENDS_WITH");
      return "ENDS_WITH";
    } else if (endWithAsterisk.equals(true)) {
      logger.debug("STARTS_WITH");
      return "STARTS_WITH";
    } else {
      logger.debug("EQUAL");
      return "EQUAL";
    }
  }
}
