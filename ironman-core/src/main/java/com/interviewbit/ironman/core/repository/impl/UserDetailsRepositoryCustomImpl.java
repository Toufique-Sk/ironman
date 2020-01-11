package com.interviewbit.ironman.core.repository.impl;


import com.interviewbit.ironman.core.models.QUserDetails;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.UserDetailsRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDetailsRepositoryCustomImpl implements UserDetailsRepositoryCustom {

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

    @Override
    public String findByMobileNo(String mobileNo) {
        return null;
    }

    public List<String> getAllUserDetailByCity(String city)
    {
        QUserDetails userDetail = QUserDetails.userDetails;
        List<String> userdetailbycity = queryFactory.select(userDetail.userId).where(userDetail.city.eq(city)).fetch();
        return userdetailbycity;
    }

}
