package com.interviewbit.ironman.core.repository.impl;

import com.interviewbit.ironman.core.models.QRequestDetails;
import com.interviewbit.ironman.core.models.RequestDetails;
import com.interviewbit.ironman.core.repository.RequestDetailsRepositoryCustom;
import com.interviewbit.ironman.dtos.enums.LendStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Toufique on 12/1/20.
 */

@Repository
public class RequestDetailsRepositoryCustomImpl implements RequestDetailsRepositoryCustom {

    @Autowired
    JPAQueryFactory queryFactory;


    @Override
    public List<RequestDetails> getRequestDetailsByUserid(String userId) {
        QRequestDetails requestDetails = QRequestDetails.requestDetails;

        List<RequestDetails> requestDetailsList = queryFactory.select(requestDetails).from(requestDetails).where(requestDetails.userId.eq(userId)).fetch();
                //.from(requestDetails).groupBy(requestDetails.userId).fetch();

        return requestDetailsList;
    }

    @Override
    @Transactional
    public void updateLendingStatus(Long id, LendStatus lendStatus) {
        QRequestDetails requestDetails = QRequestDetails.requestDetails;

        JPAUpdateClause updateClause = queryFactory.update(requestDetails)
                .set(requestDetails.lendStatus,lendStatus)
                .where(requestDetails.id.eq(String.valueOf(id)));
        updateClause.execute();
    }

    @Override
    @Transactional
    public void autoReject(Date startDate, Date endDate, Long id, String lenderId){
        QRequestDetails requestDetails = QRequestDetails.requestDetails;

        JPAUpdateClause updateClause = queryFactory.update(requestDetails)
                .set(requestDetails.lendStatus, LendStatus.REJECTED)
                .where(((requestDetails.rentDate.after(startDate)
                        .and(requestDetails.rentDate.before(endDate)))
                        .or((requestDetails.returnDate.before(endDate)).and(requestDetails.returnDate.after(startDate)))
                        .or(requestDetails.returnDate.eq(startDate).and(requestDetails.id.notEqualsIgnoreCase(String.valueOf(id))))).and(requestDetails.userId.eq(lenderId)));
        updateClause.execute();

    }
}
