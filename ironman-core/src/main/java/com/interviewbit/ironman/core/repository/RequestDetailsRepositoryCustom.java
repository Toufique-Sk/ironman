package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.RequestDetails;
import com.interviewbit.ironman.dtos.enums.LendStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Toufique on 12/1/20.
 */
public interface RequestDetailsRepositoryCustom {

    List<RequestDetails> getRequestDetailsByUserid(String userId);
    void updateLendingStatus(Long id, LendStatus lendStatus);
    void autoReject(Date startDate, Date endDate, Long id, String lenderId);
}
