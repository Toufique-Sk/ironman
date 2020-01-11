package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.LenderLendingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Toufique on 11/1/20.
 */
@Repository
public interface LenderLendingDetailsRepository  extends JpaRepository<LenderLendingDetails, String>{
}
