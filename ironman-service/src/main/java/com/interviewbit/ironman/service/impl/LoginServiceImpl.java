package com.interviewbit.ironman.service.impl;


import com.interviewbit.ironman.common.exceptions.IronmanRuntmeException;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.RegistrationRepository;
import com.interviewbit.ironman.dtos.LoginDto;
import com.interviewbit.ironman.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RegistrationRepository registrationRepository;

    public Boolean login(LoginDto loginDto){
        Optional<UserDetails> userDetails = registrationRepository.findById(loginDto.getUserId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(Objects.isNull(userDetails)){
            throw new IronmanRuntmeException("Err- 100", "UserId is invalid....");
        }
        if(userDetails.get().getUserPassword().equals(passwordEncoder.encode(loginDto.getUserPassword()))){
            return true;
        }
        else{
            throw new IronmanRuntmeException("Err-101", "Password is invalid");
        }
    }
}
