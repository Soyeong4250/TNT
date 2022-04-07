package com.ssafy.tnt.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QKeywordEntity is a Querydsl query type for KeywordEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeywordEntity extends EntityPathBase<KeywordEntity> {

    private static final long serialVersionUID = -492534410L;

    public static final QKeywordEntity keywordEntity = new QKeywordEntity("keywordEntity");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final DatePath<java.time.LocalDate> date = createDate("date", java.time.LocalDate.class);

    public final NumberPath<Integer> no = createNumber("no", Integer.class);

    public final StringPath word = createString("word");

    public QKeywordEntity(String variable) {
        super(KeywordEntity.class, forVariable(variable));
    }

    public QKeywordEntity(Path<? extends KeywordEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKeywordEntity(PathMetadata metadata) {
        super(KeywordEntity.class, metadata);
    }

}

