package com.interviewbit.ironman.api;

import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sign-up/")
public class UserRegistrationApi {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("user")
    String registerUser(@RequestBody RegistrationDto registrationDto){
        return registrationService.registerUser(registrationDto);
    }


}
