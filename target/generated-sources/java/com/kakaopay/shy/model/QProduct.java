package com.kakaopay.shy.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1457796932L;

    public static final QProduct product = new QProduct("product");

    public final NumberPath<Long> currentInvestingAmount = createNumber("currentInvestingAmount", Long.class);

    public final DateTimePath<java.time.LocalDateTime> finishedAt = createDateTime("finishedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> investCount = createNumber("investCount", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> startedAt = createDateTime("startedAt", java.time.LocalDateTime.class);

    public final EnumPath<com.kakaopay.shy.code.Status> status = createEnum("status", com.kakaopay.shy.code.Status.class);

    public final StringPath title = createString("title");

    public final NumberPath<Long> totalInvestingAmount = createNumber("totalInvestingAmount", Long.class);

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

