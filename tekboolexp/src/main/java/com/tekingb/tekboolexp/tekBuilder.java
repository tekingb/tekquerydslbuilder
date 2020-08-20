package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public final class tekBuilder {

  Logger logger = LoggerFactory.getLogger(tekBuilder.class);

  private tekPredicate predicate;

  @Autowired
  public void setPredicate(tekPredicate predicate) {
    this.predicate = predicate;
  }

  public tekBuilder() {}

  public BooleanExpression build(PathBuilder<?> entityPath, List<SearchCriteria> params) {
    logger.debug("It´s going to initialize predicate");

    if (params.size() == 0) {
      return null;
    }

    BooleanExpression result = null;

    for (SearchCriteria param : params) {
      logger.debug("params for predicate: " + param.toString());

      final BooleanExpression exp = predicate.getPredicate(entityPath, param);

      logger.debug("Exp item: " + exp);

      if (result == null) {
        result = exp;

      } else {
        result = param.isOrPredicate() ? result.or(exp) : result.and(exp);
      }
    }

    return result;
  }
}
