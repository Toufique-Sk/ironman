package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.RentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Toufique on 11/1/20.
 */
public interface RentDetailsRepository extends JpaRepository<RentDetails, String> {
}
