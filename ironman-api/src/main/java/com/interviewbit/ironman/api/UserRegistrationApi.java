package com.interviewbit.ironman.api;

import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sign-up/")
public class UserRegistrationApi {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("user/")
    public String registerUser(@RequestBody RegistrationDto registrationDto){
        return registrationService.registerUser(registrationDto);
    }

    @PostMapping("verify/{userId}/{otp}")
    public String verifyAndActivateAcc(@PathVariable("userId") String userId, @PathVariable("otp") String otp){
        Boolean response = registrationService.verifyAndActivate(userId, otp);
        if(response){
            return "Account is Activated";
        }
        else{
            return "Invalid Otp";
        }
    }


}
