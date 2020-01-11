package com.interviewbit.ironman.service.impl;

import com.google.gson.Gson;
import com.interviewbit.ironman.common.exceptions.IronmanRuntimeException;
import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.repository.LaptopDetailsRepository;
import com.interviewbit.ironman.dtos.LaptopDetailsDto;
import com.interviewbit.ironman.service.ListYourLaptopService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by Toufique on 11/1/20.
 */
public class ListYourLaptopServiceImpl implements ListYourLaptopService {

    @Autowired
    LaptopDetailsRepository laptopDetailsRepository;

    @Override
    public String listYourLaptop(LaptopDetailsDto laptopDetailsDto) {
        String laptopDetailsJson = IronmanUtils.getGson().toJson(laptopDetailsDto);
        LaptopDetails laptopDetails =IronmanUtils.getGson().fromJson(laptopDetailsJson, LaptopDetails.class);
        if(isLaptopAlreadyListed(laptopDetails.getSeriallNo())){
            throw new IronmanRuntimeException("ERR-105", "Laptop already Listed");
        }
        laptopDetailsRepository.save(laptopDetails);
        return "Your Laptop is ready to be rented";
    }

    private Boolean isLaptopAlreadyListed(String serialNo){
        Optional<LaptopDetails> laptopDetails = laptopDetailsRepository.findById(serialNo);
        if(laptopDetails.isPresent())
                return true;
        return false;
    }
}
