package com.interviewbit.ironman.core.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegistration is a Querydsl query type for Registration
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegistration extends EntityPathBase<Registration> {

    private static final long serialVersionUID = 1464937471L;

    public static final QRegistration registration = new QRegistration("registration");

    public final BooleanPath accountStatus = createBoolean("accountStatus");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final StringPath dist = createString("dist");

    public final StringPath landmark = createString("landmark");

    public final StringPath mobileNo = createString("mobileNo");

    public final StringPath state = createString("state");

    public final StringPath userEmail = createString("userEmail");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public final StringPath userPassword = createString("userPassword");

    public QRegistration(String variable) {
        super(Registration.class, forVariable(variable));
    }

    public QRegistration(Path<? extends Registration> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegistration(PathMetadata metadata) {
        super(Registration.class, metadata);
    }

}

