package com.tekingb.tekboolexp;

import com.querydsl.core.types.dsl.PathBuilder;

public interface tekParamService {

    findAllParams find(
            String search,
            String sort,
            String pagination,
            PathBuilder<?> entityPath
    );

}
