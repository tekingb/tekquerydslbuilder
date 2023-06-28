package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.PathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class tekDatePath {

  Logger logger = LoggerFactory.getLogger(tekDatePath.class);

  public tekDatePath() {}

  private String getComparator(SearchCriteria criteria) {

    if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("*")) {
      logger.debug("BETWEEN");
      return "BETWEEN";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("")) {
      logger.debug("EQUAL");
      return "EQUAL";
    } else if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("")) {
      logger.debug("AFTER");
      return "AFTER";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("*")) {
      logger.debug("BEFORE");
      return "BEFORE";
    } else if (criteria.getPrefix().equals("/") && criteria.getSuffix().equals("")) {
      logger.debug("GREATER_THAN");
      return "GREATER_THAN";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("/")) {
      logger.debug("LESS_THAN");
      return "LESS_THAN";
    } else if (criteria.getPrefix().equals("/") && criteria.getSuffix().equals("/")) {
      logger.debug("DAY OF MONTH");
      return "DAY OF MONTH";
    } else if (criteria.getPrefix().equals("!") && criteria.getSuffix().equals("")) {
      logger.debug("MONTH");
      return "MONTH";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("!")) {
      logger.debug("YEAR");
      return "YEAR";
    } else if (criteria.getPrefix().equals("!") && criteria.getSuffix().equals("!")) {
      logger.debug("YEAR_MONTH");
      return "YEAR_MONTH";
    } else if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("!")) {
      logger.debug("NULL");
      return "IS NULL";
    } else {
      return "EQUAL";
    }
  }

  public BooleanExpression getDatePath(
      PathBuilder<?> entityPath, String op, SearchCriteria criteria) {

    logger.debug("Getting datePath");

    String comparator = getComparator(criteria);

    switch (criteria.getKeyType()) {
      case "!": // Simple date
        logger.debug("LocalDate Search");
        final LocalDate localDateValue;
        final Integer integerLocalDateValue;
        final LocalDate localDateValue1;
        final LocalDate localDateValue2;

        final DatePath<LocalDate> DatePath = entityPath.getDate(criteria.getKey(), LocalDate.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            localDateValue1 =
                LocalDate.parse(
                    criteria.getValue().toString().split(";")[0], DateTimeFormatter.ISO_LOCAL_DATE);
            localDateValue2 =
                LocalDate.parse(
                    criteria.getValue().toString().split(";")[1], DateTimeFormatter.ISO_LOCAL_DATE);
            if (op != null && op.equals("NEGATION")) {
              return DatePath.between(localDateValue1, localDateValue2).not();
            } else {
              return DatePath.between(localDateValue1, localDateValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            localDateValue =
                LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
            if (op != null && op.equals("NEGATION")) {
              return DatePath.goe(localDateValue).not();
            } else {
              return DatePath.goe(localDateValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            localDateValue =
                LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);

            if (op != null && op.equals("NEGATION")) {
              return DatePath.loe(localDateValue).not();
            } else {
              return DatePath.loe(localDateValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            localDateValue =
                LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);

            if (op != null && op.equals("NEGATION")) {
              return DatePath.eq(localDateValue).not();
            } else {
              return DatePath.eq(localDateValue);
            }

          case "AFTER":
            logger.debug("Comparator in AFTER");
            localDateValue =
                LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);

            if (op != null && op.equals("NEGATION")) {
              return DatePath.after(localDateValue).not();
            } else {
              return DatePath.after(localDateValue);
            }

          case "BEFORE":
            logger.debug("Comparator in BEFORE");
            localDateValue =
                LocalDate.parse(criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE);

            if (op != null && op.equals("NEGATION")) {
              return DatePath.before(localDateValue).not();
            } else {
              return DatePath.before(localDateValue);
            }

          case "DAY OF MONTH":
            logger.debug("Comparator in DAY OF MONTH");
            integerLocalDateValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DatePath.dayOfMonth().eq(integerLocalDateValue).not();
            } else {
              return DatePath.dayOfMonth().eq(integerLocalDateValue);
            }

          case "MONTH":
            logger.debug("Comparator in MONTH");
            integerLocalDateValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DatePath.month().eq(integerLocalDateValue).not();
            } else {
              return DatePath.month().eq(integerLocalDateValue);
            }

          case "YEAR":
            logger.debug("Comparator in YEAR");
            integerLocalDateValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DatePath.year().eq(integerLocalDateValue).not();
            } else {
              return DatePath.year().eq(integerLocalDateValue);
            }

          case "YEAR_MONTH":
            logger.debug("Comparator in YEAR_MONTH");
            integerLocalDateValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DatePath.yearMonth().eq(integerLocalDateValue).not();
            } else {
              return DatePath.yearMonth().eq(integerLocalDateValue);
            }

          case "IS NULL":
            logger.debug("IS NULL");

            if (op != null && op.equals("NEGATION")) {
              return DatePath.isNull().not();
            } else {
              return DatePath.isNull();
            }
        }

      case ".": // LocalDateTime
        logger.debug("LocalDate Search");
        final LocalDateTime localDateTimeValue;
        final Integer integerLocalDateTimeValue;
        final LocalDateTime localDateTimeValue1;
        final LocalDateTime localDateTimeValue2;

        final DateTimePath<LocalDateTime> DateTimePath =
            entityPath.getDateTime(criteria.getKey(), LocalDateTime.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            localDateTimeValue1 =
                LocalDateTime.parse(
                    criteria.getValue().toString().split(";")[0],
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            localDateTimeValue2 =
                LocalDateTime.parse(
                    criteria.getValue().toString().split(";")[1],
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.between(localDateTimeValue1, localDateTimeValue2).not();
            } else {
              return DateTimePath.between(localDateTimeValue1, localDateTimeValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            localDateTimeValue =
                LocalDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.goe(localDateTimeValue).not();
            } else {
              return DateTimePath.goe(localDateTimeValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            localDateTimeValue =
                LocalDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.loe(localDateTimeValue).not();
            } else {
              return DateTimePath.loe(localDateTimeValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            localDateTimeValue =
                LocalDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.eq(localDateTimeValue).not();
            } else {
              return DateTimePath.eq(localDateTimeValue);
            }

          case "AFTER":
            logger.debug("Comparator in AFTER");
            localDateTimeValue =
                LocalDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.after(localDateTimeValue).not();
            } else {
              return DateTimePath.after(localDateTimeValue);
            }

          case "BEFORE":
            logger.debug("Comparator in BEFORE");
            localDateTimeValue =
                LocalDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.before(localDateTimeValue).not();
            } else {
              return DateTimePath.before(localDateTimeValue);
            }

          case "DAY OF MONTH":
            logger.debug("Comparator in DAY OF MONTH");
            integerLocalDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.dayOfMonth().eq(integerLocalDateTimeValue).not();
            } else {
              return DateTimePath.dayOfMonth().eq(integerLocalDateTimeValue);
            }

          case "MONTH":
            logger.debug("Comparator in MONTH");
            integerLocalDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.month().eq(integerLocalDateTimeValue).not();
            } else {
              return DateTimePath.month().eq(integerLocalDateTimeValue);
            }

          case "YEAR":
            logger.debug("Comparator in YEAR");
            integerLocalDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.year().eq(integerLocalDateTimeValue).not();
            } else {
              return DateTimePath.year().eq(integerLocalDateTimeValue);
            }

          case "YEAR_MONTH":
            logger.debug("Comparator in YEAR_MONTH");
            integerLocalDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.yearMonth().eq(integerLocalDateTimeValue).not();
            } else {
              return DateTimePath.yearMonth().eq(integerLocalDateTimeValue);
            }

          case "IS NULL":
            logger.debug("IS NULL");

            if (op != null && op.equals("NEGATION")) {
              return DateTimePath.isNull().not();
            } else {
              return DateTimePath.isNull();
            }
        }

      case "|": // DateTimePath
        logger.debug("ZonedDateTime Search");
        final ZonedDateTime zonedDateTimeValue;
        final Integer integerZonedDateTimeValue;
        final ZonedDateTime zonedDateTimeValue1;
        final ZonedDateTime zonedDateTimeValue2;

        final DateTimePath<ZonedDateTime> zonedDateTimePath =
            entityPath.getDateTime(criteria.getKey(), ZonedDateTime.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            zonedDateTimeValue1 =
                ZonedDateTime.parse(
                    criteria.getValue().toString().split(";")[0],
                    DateTimeFormatter.ISO_ZONED_DATE_TIME);
            zonedDateTimeValue2 =
                ZonedDateTime.parse(
                    criteria.getValue().toString().split(";")[1],
                    DateTimeFormatter.ISO_ZONED_DATE_TIME);
            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.between(zonedDateTimeValue1, zonedDateTimeValue2).not();
            } else {
              return zonedDateTimePath.between(zonedDateTimeValue1, zonedDateTimeValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            zonedDateTimeValue =
                ZonedDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.goe(zonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.goe(zonedDateTimeValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            zonedDateTimeValue =
                ZonedDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.loe(zonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.loe(zonedDateTimeValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            zonedDateTimeValue =
                ZonedDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.eq(zonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.eq(zonedDateTimeValue);
            }

          case "AFTER":
            logger.debug("Comparator in AFTER");
            zonedDateTimeValue =
                ZonedDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.after(zonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.after(zonedDateTimeValue);
            }

          case "BEFORE":
            logger.debug("Comparator in BEFORE");
            zonedDateTimeValue =
                ZonedDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.before(zonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.before(zonedDateTimeValue);
            }

          case "DAY OF MONTH":
            logger.debug("Comparator in DAY OF MONTH");
            integerZonedDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.dayOfMonth().eq(integerZonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.dayOfMonth().eq(integerZonedDateTimeValue);
            }

          case "MONTH":
            logger.debug("Comparator in MONTH");
            integerZonedDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.month().eq(integerZonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.month().eq(integerZonedDateTimeValue);
            }

          case "YEAR":
            logger.debug("Comparator in YEAR");
            integerZonedDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.year().eq(integerZonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.year().eq(integerZonedDateTimeValue);
            }

          case "YEAR_MONTH":
            logger.debug("Comparator in YEAR_MONTH");
            integerZonedDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.yearMonth().eq(integerZonedDateTimeValue).not();
            } else {
              return zonedDateTimePath.yearMonth().eq(integerZonedDateTimeValue);
            }

          case "IS NULL":
            logger.debug("IS NULL");

            if (op != null && op.equals("NEGATION")) {
              return zonedDateTimePath.isNull().not();
            } else {
              return zonedDateTimePath.isNull();
            }
        }

      case "@": // OffsetDateTime
        logger.debug("OffsetDateTime Search");
        final OffsetDateTime offsetDateTimeValue;
        final Integer integerOffsetDateTimeValue;
        final OffsetDateTime offsetDateTimeValue1;
        final OffsetDateTime offsetDateTimeValue2;

        final DateTimePath<OffsetDateTime> offsetDateTimePath =
            entityPath.getDateTime(criteria.getKey(), OffsetDateTime.class);

        switch (comparator) {
          case "BETWEEN":
            logger.debug("Comparator in BETWEEN");

            offsetDateTimeValue1 =
                OffsetDateTime.parse(
                    criteria.getValue().toString().split(";")[0],
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            offsetDateTimeValue2 =
                OffsetDateTime.parse(
                    criteria.getValue().toString().split(";")[1],
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.between(offsetDateTimeValue1, offsetDateTimeValue2).not();
            } else {
              return offsetDateTimePath.between(offsetDateTimeValue1, offsetDateTimeValue2);
            }

          case "GREATER_THAN":
            logger.debug("Comparator in GREATER_THAN");
            offsetDateTimeValue =
                OffsetDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.goe(offsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.goe(offsetDateTimeValue);
            }

          case "LESS_THAN":
            logger.debug("Comparator in LESS_THAN");
            offsetDateTimeValue =
                OffsetDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.loe(offsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.loe(offsetDateTimeValue);
            }

          case "EQUAL":
            logger.debug("Comparator in EQUAL");
            offsetDateTimeValue =
                OffsetDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.eq(offsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.eq(offsetDateTimeValue);
            }

          case "AFTER":
            logger.debug("Comparator in AFTER");
            offsetDateTimeValue =
                OffsetDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.after(offsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.after(offsetDateTimeValue);
            }

          case "BEFORE":
            logger.debug("Comparator in BEFORE");
            offsetDateTimeValue =
                OffsetDateTime.parse(
                    criteria.getValue().toString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.before(offsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.before(offsetDateTimeValue);
            }

          case "DAY OF MONTH":
            logger.debug("Comparator in DAY OF MONTH");
            integerOffsetDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.dayOfMonth().eq(integerOffsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.dayOfMonth().eq(integerOffsetDateTimeValue);
            }

          case "MONTH":
            logger.debug("Comparator in MONTH");
            integerOffsetDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.month().eq(integerOffsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.month().eq(integerOffsetDateTimeValue);
            }

          case "YEAR":
            logger.debug("Comparator in YEAR");
            integerOffsetDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.year().eq(integerOffsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.year().eq(integerOffsetDateTimeValue);
            }

          case "YEAR_MONTH":
            logger.debug("Comparator in YEAR_MONTH");
            integerOffsetDateTimeValue = Integer.parseInt(criteria.getValue().toString());

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.yearMonth().eq(integerOffsetDateTimeValue).not();
            } else {
              return offsetDateTimePath.yearMonth().eq(integerOffsetDateTimeValue);
            }

          case "IS NULL":
            logger.debug("IS NULL");

            if (op != null && op.equals("NEGATION")) {
              return offsetDateTimePath.isNull().not();
            } else {
              return offsetDateTimePath.isNull();
            }
        }
    }

    return null;
  }
}
