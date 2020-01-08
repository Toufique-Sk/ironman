package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.core.models.Registration;
import com.interviewbit.ironman.core.repository.RegistrationRepository;
import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public String registerUser(RegistrationDto registrationDto) {
        String registrationJson = IronmanUtils.getGson().toJson(registrationDto);
        registrationRepository.save(IronmanUtils.getGson().fromJson(registrationJson, Registration.class));
        return registrationDto.getUserName()+" registered";
    }
}
