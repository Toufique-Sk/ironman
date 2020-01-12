package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.common.exceptions.IronmanRuntimeException;
import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.UserDetailsRepository;
import com.interviewbit.ironman.core.repository.UserDetailsRepositoryCustom;
import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.RegistrationService;
import com.interviewbit.ironman.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserDetailsRepository registrationRepository;

    @Autowired
    UserDetailsRepositoryCustom registrationRepositoryCustom;

    @Autowired
    private SendMessageService sendOtpService;



    @Override
    public String registerUser(RegistrationDto registrationDto) {
        String registrationJson = IronmanUtils.getGson().toJson(registrationDto);
        UserDetails userDetails = IronmanUtils.getGson().fromJson(registrationJson, UserDetails.class);
        userDetails.setAccountStatus(false);
        userDetails.setUserPassword(IronmanUtils.passwordHashFunction(userDetails.getUserPassword()));
        String receivedOtp = sendOtpService.sendOtp(userDetails.getMobileNo());
        userDetails.setOtp(String.valueOf(receivedOtp.hashCode()));
        if(isUserIdPresent(userDetails.getUserId())){
            throw new IronmanRuntimeException("Err-104", "UserId in use");
        }
        registrationRepository.save(userDetails);
        return registrationDto.getUserName()+": Please verify your account ";
    }

    @Override
    public Boolean verifyAndActivate(String userId, String enteredOtp) {
        String receivedOtp = registrationRepository.findById(userId).get().getOtp();
        String enteredOtpHash = String.valueOf(enteredOtp.hashCode());
        if(enteredOtpHash.equals(receivedOtp)){
            registrationRepositoryCustom.updateAccountStatus(userId);
        }
        else{
            return false;
        }
        return true;
    }

    private Boolean isUserIdPresent(String userId){
        Optional<UserDetails> userDetails = registrationRepository.findById(userId);
        if(userDetails.isPresent()){
            return true;
        }
        return false;
    }
}
