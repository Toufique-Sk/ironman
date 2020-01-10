package com.interviewbit.ironman.api;


import com.interviewbit.ironman.dtos.LoginDto;
import com.interviewbit.ironman.dtos.RegistrationDto;
import com.interviewbit.ironman.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login/")
public class UserLogin {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Boolean login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}
