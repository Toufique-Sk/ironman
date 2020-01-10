package com.interviewbit.ironman.core.repository.impl;

import com.interviewbit.ironman.core.models.QUserDetails;
import com.interviewbit.ironman.core.repository.RegistrationRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class RegistrationRepositoryCustomImpl implements RegistrationRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    @Transactional
    public void updateAccountStatus(String userId) {

        QUserDetails registration = QUserDetails.userDetails;
        JPAUpdateClause updateClause = queryFactory.update(registration)
                .set(registration.accountStatus, true)
                .where(registration.userId.eq(userId));
        updateClause.execute();
    }
}
