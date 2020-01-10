package com.interviewbit.ironman.service;

import com.interviewbit.ironman.core.repository.RentDetailsRepository;
import com.interviewbit.ironman.dtos.RentDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Toufique on 11/1/20.
 */
public interface RentALaptopService {

    String requestLaptop(RentDto rentDto);

    String rentApproved(String borrowerUserId);
}
