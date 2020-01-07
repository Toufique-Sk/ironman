package com.interviewbit.ironman.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorld {

    @GetMapping("/name")
    public String getName(){
        return "I am ironman";
    }
}
