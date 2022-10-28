package com.kurly.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProImg is a Querydsl query type for ProImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProImg extends EntityPathBase<ProImg> {

    private static final long serialVersionUID = 1553220635L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProImg proImg = new QProImg("proImg");

    public final com.kurly.config.QBaseEntity _super = new com.kurly.config.QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgName = createString("imgName");

    public final StringPath imgUrl = createString("imgUrl");

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath oriImgName = createString("oriImgName");

    public final QProduct product;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final StringPath repImgYn = createString("repImgYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateTime = _super.updateTime;

    public QProImg(String variable) {
        this(ProImg.class, forVariable(variable), INITS);
    }

    public QProImg(Path<? extends ProImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProImg(PathMetadata metadata, PathInits inits) {
        this(ProImg.class, metadata, inits);
    }

    public QProImg(Class<? extends ProImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

