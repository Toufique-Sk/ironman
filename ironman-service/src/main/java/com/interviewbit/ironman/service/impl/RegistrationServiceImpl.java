package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.core.models.Registration;
import com.interviewbit.ironman.core.repository.RegistrationRepository;
import com.interviewbit.ironman.core.repository.RegistrationRepositoryCustom;
import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.RegistrationService;
import com.interviewbit.ironman.service.SendOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    RegistrationRepositoryCustom registrationRepositoryCustom;

    @Autowired
    private SendOtpService sendOtpService;

    @Override
    public String registerUser(RegistrationDto registrationDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String registrationJson = IronmanUtils.getGson().toJson(registrationDto);
        Registration registration = IronmanUtils.getGson().fromJson(registrationJson, Registration.class);
        registration.setAccountStatus(false);
        registration.setUserPassword(passwordEncoder.encode(registration.getUserPassword()));
        String receivedOtp = sendOtpService.sendOtp(registration.getMobileNo());
        registration.setOtp(String.valueOf(receivedOtp.hashCode()));
        registrationRepository.save(registration);
        return registrationDto.getUserName()+": Please verify your account " + receivedOtp;
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

    private String getUserMobileNo(String userId){
        return registrationRepository.findById(userId).get().getMobileNo();
    }


}
