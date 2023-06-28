package com.tekingb.tekboolexp;

import com.google.common.base.Joiner;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class tekParam implements tekParamService {

  Logger logger = LoggerFactory.getLogger(tekParam.class);

  private List<SearchCriteria> params = new ArrayList<>();

  private tekBuilder builder;

  private static final String[] SIMPLE_OPERATION_SET = {":", "!", ">", "<", "~"};

  private int defaultPageNumber;

  private int defaultPageSize;

  private String defaultOrderBy;


  public tekParam(int defaultPageNumber, int defaultPageSize, String defaultOrderBy) {
    this.defaultPageNumber = defaultPageNumber;
    this.defaultPageSize = defaultPageSize;
    this.defaultOrderBy = defaultOrderBy;
  }

  @Autowired
  public void setBuilder(tekBuilder builder) {
    this.builder = builder;
  }

  public int getDefaultPageNumber() {
    return defaultPageNumber;
  }

  public void setDefaultPageNumber(int defaultPageNumber) {
    this.defaultPageNumber = defaultPageNumber;
  }

  public int getDefaultPageSize() {
    return defaultPageSize;
  }

  public void setDefaultPageSize(int defaultPageSize) {
    this.defaultPageSize = defaultPageSize;
  }

  public String getDefaultOrderBy() {
    return defaultOrderBy;
  }

  public void setDefaultOrderBy(String defaultOrderBy) {
    this.defaultOrderBy = defaultOrderBy;
  }

  public findAllParams find(
      String search,
      String sort,
      String pagination,
      PathBuilder<?> entityPath
      ) {

    if (search != null) {

      String operationSetExp = Joiner.on("|").join(SIMPLE_OPERATION_SET);
      Pattern pattern =
          Pattern.compile(
              "(\\p{Punct}?)(\\p{Punct}?)(\\p{Punct}?)(\\w.+?)("
                  + operationSetExp
                  + ")(\\p{Punct}?)([^*]+?)(\\p{Punct}?),");

      logger.debug("search: " + search);
      logger.debug("pattern: " + pattern);

      Matcher matcher = pattern.matcher(search + ",");

      List<SearchCriteria> paramsTemp = new ArrayList<>();

      while (matcher.find()) {
        paramsTemp.add(
            new SearchCriteria(
                matcher.group(3),
                matcher.group(4),
                matcher.group(5),
                matcher.group(7),
                matcher.group(2),
                matcher.group(6),
                matcher.group(8),
                matcher.group(1)));
      }

      params = paramsTemp;

      logger.debug("params: " + this.params.toString());
    }

    int pageNumber = defaultPageNumber;
    int pageSize = defaultPageSize;

    if (pagination != null) {
      String operationSetExp3 = Joiner.on("|").join(SIMPLE_OPERATION_SET);
      Pattern pattern3 = Pattern.compile("(\\w+?)(" + operationSetExp3 + ")(\\w+?),");
      Matcher matcher3 = pattern3.matcher(pagination + ",");

      while (matcher3.find()) {

        if (matcher3.group(1).equalsIgnoreCase("page")) {
          pageNumber = Integer.parseInt(matcher3.group(3));
        }

        if (matcher3.group(1).equalsIgnoreCase("size")) {
          pageSize = Integer.parseInt(matcher3.group(3));
        }
      }
    }

    List<Order> orderObjects = new ArrayList<>();

    Order orderObject = new Order(Direction.DESC, defaultOrderBy, NullHandling.NULLS_LAST);

    if (sort != null) {

      logger.debug("String sort: " + sort);

      String operationSetExp2 = Joiner.on("|").join(SIMPLE_OPERATION_SET);
      Pattern pattern2 =
          Pattern.compile("(\\p{Punct}?)(\\w+?)(" + operationSetExp2 + ")(\\w+?),");

      Matcher matcher2 = pattern2.matcher(sort + ",");

      while (matcher2.find()) {

        logger.debug("Operator: " + matcher2.group(3));

        switch (matcher2.group(3)) {
          case ":":
            logger.debug("NullHandling: NULLS_LAST");

            if (matcher2.group(4).equalsIgnoreCase("ASC")) {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.ASC, matcher2.group(2), NullHandling.NULLS_LAST)
                          .ignoreCase()
                      : new Order(Direction.ASC, matcher2.group(2), NullHandling.NULLS_LAST);

            } else {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.DESC, matcher2.group(2), NullHandling.NULLS_LAST)
                          .ignoreCase()
                      : new Order(Direction.DESC, matcher2.group(2), NullHandling.NULLS_LAST);
            }

            break;

          case "<":
            logger.debug("NullHandling: NULLS_FIRST");

            if (matcher2.group(4).equalsIgnoreCase("ASC")) {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.ASC, matcher2.group(2), NullHandling.NULLS_FIRST)
                          .ignoreCase()
                      : new Order(Direction.ASC, matcher2.group(2), NullHandling.NULLS_FIRST);

            } else {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.DESC, matcher2.group(2), NullHandling.NULLS_FIRST)
                          .ignoreCase()
                      : new Order(Direction.DESC, matcher2.group(2), NullHandling.NULLS_FIRST);
            }

            break;

          case ">":
            logger.debug("NullHandling: NATIVE");

            if (matcher2.group(4).equalsIgnoreCase("ASC")) {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.ASC, matcher2.group(2), NullHandling.NATIVE)
                          .ignoreCase()
                      : new Order(Direction.ASC, matcher2.group(2), NullHandling.NATIVE);

            } else {

              orderObject =
                  matcher2.group(1).equals("*")
                      ? new Order(Direction.DESC, matcher2.group(2), NullHandling.NATIVE)
                          .ignoreCase()
                      : new Order(Direction.DESC, matcher2.group(2), NullHandling.NATIVE);
            }

            break;
        }

        orderObjects.add(orderObject);
      }
    }

    if (orderObjects.isEmpty()) {
      orderObjects.add(orderObject);
    }

    Pageable pageRequest = createPageRequest(pageNumber, pageSize, orderObjects);

    logger.debug("Before build");
    BooleanExpression exp = builder.build(entityPath, params);

    logger.debug("pageRequest: " + pageRequest);
    logger.debug("Exp: " + exp);

    findAllParams findAllParams = new findAllParams();

    findAllParams.setExp(exp);

    findAllParams.setPageRequest(pageRequest);

    return findAllParams;
  }

  private Pageable createPageRequest(int page, int pageSize, List<Order> orderObjects) {
    return PageRequest.of(page, pageSize, Sort.by(orderObjects));
  }
}
