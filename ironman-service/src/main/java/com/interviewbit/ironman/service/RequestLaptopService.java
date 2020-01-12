package com.interviewbit.ironman.service;

import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.dtos.RequestListOfUser;
import com.interviewbit.ironman.dtos.enums.LendStatus;

import java.util.List;

/**
 * Created by Toufique on 11/1/20.
 */
public interface RequestLaptopService {

    void requestLaptop(RentDto rentDto);

    List<RequestListOfUser> getLaptopRequestListByUser(String userId);

    String modifyRequest(Long id,String lenderId, LendStatus lendStatus);
}
