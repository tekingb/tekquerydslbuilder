package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Pageable;

public class findAllParams {

  private Pageable pageRequest;

  private BooleanExpression exp;

  public Pageable getPageRequest() {
    return pageRequest;
  }

  public void setPageRequest(Pageable pageRequest) {
    this.pageRequest = pageRequest;
  }

  public BooleanExpression getExp() {
    return exp;
  }

  public void setExp(BooleanExpression exp) {
    this.exp = exp;
  }
}
