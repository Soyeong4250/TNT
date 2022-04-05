package com.ssafy.tnt.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNews is a Querydsl query type for News
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNews extends EntityPathBase<News> {

    private static final long serialVersionUID = -958626487L;

    public static final QNews news = new QNews("news");

    public final StringPath category = createString("category");

    public final StringPath company = createString("company");

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final StringPath newsUrl = createString("newsUrl");

    public final NumberPath<Long> no = createNumber("no", Long.class);

    public final StringPath reporter = createString("reporter");

    public final StringPath title = createString("title");

    public final StringPath tumbnailUrl = createString("tumbnailUrl");

    public QNews(String variable) {
        super(News.class, forVariable(variable));
    }

    public QNews(Path<? extends News> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNews(PathMetadata metadata) {
        super(News.class, metadata);
    }

}

