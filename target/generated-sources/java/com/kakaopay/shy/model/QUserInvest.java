package com.kakaopay.shy.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInvest is a Querydsl query type for UserInvest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserInvest extends EntityPathBase<UserInvest> {

    private static final long serialVersionUID = -1933398741L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserInvest userInvest = new QUserInvest("userInvest");

    public final DateTimePath<java.time.LocalDateTime> cretDt = createDateTime("cretDt", java.time.LocalDateTime.class);

    public final QProduct product;

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> userInvestingAmount = createNumber("userInvestingAmount", Long.class);

    public QUserInvest(String variable) {
        this(UserInvest.class, forVariable(variable), INITS);
    }

    public QUserInvest(Path<? extends UserInvest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserInvest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserInvest(PathMetadata metadata, PathInits inits) {
        this(UserInvest.class, metadata, inits);
    }

    public QUserInvest(Class<? extends UserInvest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

