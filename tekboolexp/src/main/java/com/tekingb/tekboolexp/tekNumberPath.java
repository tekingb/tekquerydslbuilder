package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public final class tekNumberPath {

  Logger logger = LoggerFactory.getLogger(tekNumberPath.class);

  public tekNumberPath() {}

  private String getComparator(Boolean startWithAsterisk, Boolean endWithAsterisk) {

    if (startWithAsterisk.equals(true) && endWithAsterisk.equals(true)) {
      logger.debug("BETWEEN");
      return "BETWEEN";
    } else if (startWithAsterisk.equals(true)) {
      logger.debug("GREATER_THAN");
      return "GREATER_THAN";
    } else if (endWithAsterisk.equals(true)) {
      logger.debug("LESS_THAN");
      return "LESS_THAN";
    } else {
      logger.debug("EQUAL");
      return "EQUAL";
    }
  }

  public BooleanExpression getNumberPath(
      PathBuilder<?> entityPath, String op, SearchCriteria criteria) {

    final boolean startWithAsterisk;
    final boolean endWithAsterisk;

    startWithAsterisk =
        criteria.getPrefix() != null
            && criteria.getPrefix().contains("*");
    endWithAsterisk =
        criteria.getSuffix() != null
            && criteria.getSuffix().contains("*");

    String comparator = getComparator(startWithAsterisk, endWithAsterisk);

    switch (criteria.getKeyType()) {
      case "-": // Numeric Integer
        logger.debug("Integer Search");
        final Integer integerValue;
        final Integer integerValue1;
        final Integer integerValue2;

        final NumberPath<Integer> NumberPathInteger =
            entityPath.getNumber(criteria.getKey(), Integer.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            integerValue1 = Integer.parseInt(criteria.getValue().toString().split(";")[0]);
            integerValue2 = Integer.parseInt(criteria.getValue().toString().split(";")[1]);
            if (op != null && op.equals("NEGATION")) {
              return NumberPathInteger.between(integerValue1, integerValue2).not();
            } else {
              return NumberPathInteger.between(integerValue1, integerValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            integerValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathInteger.goe(integerValue).not();
            } else {
              return NumberPathInteger.goe(integerValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            integerValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathInteger.loe(integerValue).not();
            } else {
              return NumberPathInteger.loe(integerValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            integerValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathInteger.eq(integerValue).not();
            } else {
              return NumberPathInteger.eq(integerValue);
            }
        }

      case "[": // Numeric Double
        logger.debug("Double Search");
        final Double doubleValue;
        final Double doubleValue1;
        final Double doubleValue2;

        final NumberPath<Double> NumberPathDouble =
            entityPath.getNumber(criteria.getKey(), Double.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            doubleValue1 = Double.parseDouble(criteria.getValue().toString().split(";")[0]);
            doubleValue2 = Double.parseDouble(criteria.getValue().toString().split(";")[1]);
            if (op != null && op.equals("NEGATION")) {
              return NumberPathDouble.between(doubleValue1, doubleValue2).not();
            } else {
              return NumberPathDouble.between(doubleValue1, doubleValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            doubleValue = Double.parseDouble(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathDouble.goe(doubleValue).not();
            } else {
              return NumberPathDouble.goe(doubleValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            doubleValue = Double.parseDouble(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathDouble.loe(doubleValue).not();
            } else {
              return NumberPathDouble.loe(doubleValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            doubleValue = Double.parseDouble(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathDouble.eq(doubleValue).not();
            } else {
              return NumberPathDouble.eq(doubleValue);
            }
        }

      case "{": // Numeric Long
        logger.debug("Long Search");

        final Long longValue;
        final Long longValue1;
        final Long longValue2;

        final NumberPath<Long> NumberPathLong = entityPath.getNumber(criteria.getKey(), Long.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            longValue1 = Long.parseLong(criteria.getValue().toString().split(";")[0]);
            longValue2 = Long.parseLong(criteria.getValue().toString().split(";")[1]);
            if (op != null && op.equals("NEGATION")) {
              return NumberPathLong.between(longValue1, longValue2).not();
            } else {
              return NumberPathLong.between(longValue1, longValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            longValue = Long.parseLong(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathLong.goe(longValue).not();
            } else {
              return NumberPathLong.goe(longValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            longValue = Long.parseLong(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathLong.loe(longValue).not();
            } else {
              return NumberPathLong.loe(longValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            longValue = Long.parseLong(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathLong.eq(longValue).not();
            } else {
              return NumberPathLong.eq(longValue);
            }
        }

      case "}": // Numeric BigDecimal
        logger.debug("Big Decimal Search");

        final BigDecimal bigDecimalValue;
        final BigDecimal bigDecimalValue1;
        final BigDecimal bigDecimalValue2;

        final NumberPath<BigDecimal> NumberPathBigDecimal =
            entityPath.getNumber(criteria.getKey(), BigDecimal.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            bigDecimalValue1 = new BigDecimal(criteria.getValue().toString().split(";")[0]);
            bigDecimalValue2 = new BigDecimal(criteria.getValue().toString().split(";")[1]);
            if (op != null && op.equals("NEGATION")) {
              return NumberPathBigDecimal.between(bigDecimalValue1, bigDecimalValue2).not();
            } else {
              return NumberPathBigDecimal.between(bigDecimalValue1, bigDecimalValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            bigDecimalValue = new BigDecimal(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathBigDecimal.goe(bigDecimalValue).not();
            } else {
              return NumberPathBigDecimal.goe(bigDecimalValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            bigDecimalValue = new BigDecimal(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathBigDecimal.loe(bigDecimalValue).not();
            } else {
              return NumberPathBigDecimal.loe(bigDecimalValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            bigDecimalValue = new BigDecimal(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return NumberPathBigDecimal.eq(bigDecimalValue).not();
            } else {
              return NumberPathBigDecimal.eq(bigDecimalValue);
            }
        }
    }
    return null;
  }
}
