package com.interviewbit.ironman.service;

import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.repository.RentDetailsRepository;
import com.interviewbit.ironman.dtos.RentDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Toufique on 11/1/20.
 */
public interface RentALaptopService {

    String requestLaptop(RentDto rentDto);

    String rentApproved(String borrowerUserId);

    List<LaptopDetails> filterByProcessor(String processor);

    List<LaptopDetails> filterByRam(int ram);
}
