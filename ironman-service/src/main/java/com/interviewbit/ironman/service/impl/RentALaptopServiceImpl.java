package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.LaptopDetailsRepository;
import com.interviewbit.ironman.core.repository.RentDetailsRepository;
import com.interviewbit.ironman.core.repository.UserDetailsRepository;
import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.service.RentALaptopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by Toufique on 11/1/20.
 */
public class RentALaptopServiceImpl  implements RentALaptopService{

    @Autowired
    private RentDetailsRepository rentDetailsRepository;

    @Autowired
    private LaptopDetailsRepository laptopDetailsRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Override
    public String requestLaptop(RentDto rentDto) {
        Optional<LaptopDetails> laptopDetails = laptopDetailsRepository.findById(rentDto.getLaptopId());
        Optional<UserDetails> lenderDetails = userDetailsRepository.findById(laptopDetails.get().getUserId());
        return null;
    }

    @Override
    public String rentApproved(String borrowerUserId) {
        return null;
    }




}
