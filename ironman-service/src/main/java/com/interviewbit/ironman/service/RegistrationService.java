package com.interviewbit.ironman.service;

import com.interviewbit.ironman.dtos.RegistrationDto;


public interface RegistrationService {
    String registerUser(RegistrationDto registrationDto);
    Boolean verifyAndActivate(String userid, String enteredOtp);
}
