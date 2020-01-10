package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.core.repository.RentDetailsRepository;
import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.service.RentALaptopService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Toufique on 11/1/20.
 */
public class RentALaptopServiceImpl  implements RentALaptopService{

    @Autowired
    private RentDetailsRepository rentDetailsRepository;

    @Override
    public String requestLaptop(RentDto rentDto) {
        return null;
    }

    @Override
    public String rentApproved(String borrowerUserId) {
        return null;
    }


}
