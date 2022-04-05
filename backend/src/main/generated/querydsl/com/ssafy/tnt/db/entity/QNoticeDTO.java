package com.ssafy.tnt.db.entity;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.ssafy.tnt.db.entity.QNoticeDTO is a Querydsl Projection type for NoticeDTO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QNoticeDTO extends ConstructorExpression<NoticeDTO> {

    private static final long serialVersionUID = -127204559L;

    public QNoticeDTO(com.querydsl.core.types.Expression<? extends Notice> notice, com.querydsl.core.types.Expression<? extends User> user) {
        super(NoticeDTO.class, new Class<?>[]{Notice.class, User.class}, notice, user);
    }

}

