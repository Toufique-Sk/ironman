package com.interviewbit.ironman.service.impl;


import com.interviewbit.ironman.common.exceptions.IronmanRuntimeException;
import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.RegistrationRepository;
import com.interviewbit.ironman.dtos.LoginDto;
import com.interviewbit.ironman.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RegistrationRepository registrationRepository;

    public Boolean login(LoginDto loginDto){
        Optional<UserDetails> userDetails = registrationRepository.findById(loginDto.getUserId());

        if(!userDetails.isPresent()){
            throw new IronmanRuntimeException("Err- 100", "UserId is invalid....");
        }
        if(userDetails.get().getAccountStatus() == false){
            throw new IronmanRuntimeException("Error-101", "Please verify your mobile number");
        }
        if(userDetails.get().getUserPassword().equals(IronmanUtils.passwordHashFunction(loginDto.getUserPassword()))){
            return true;
        }
        else {
            throw new IronmanRuntimeException("Err-102", "Password is invalid");
        }
    }
}
