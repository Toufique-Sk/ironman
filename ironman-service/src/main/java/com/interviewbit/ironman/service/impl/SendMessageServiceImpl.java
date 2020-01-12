package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.common.utils.IronmanUtils;
import com.interviewbit.ironman.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Random;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    private final static String API_KEY = "c5988bb8-33d3-11ea-9fa5-0200cd936042/";
    private final static String sendSmsBaseUrl = "https://2factor.in/API/V1/";


    @Autowired
    RestTemplate restTemplate;

    private String getOtp(){
        Random randomNumber = new Random();
        return String.valueOf(randomNumber.nextInt((9999 - 1001) + 1));
    }


    public String sendOtp(String mobileNo){

        UriComponentsBuilder url = IronmanUtils.getUrl(sendSmsBaseUrl);
        url.path(API_KEY);
        url.path("SMS/+91");
        url.path(mobileNo+"/");
        String otp =getOtp();
        url.path(otp);

        HttpEntity entity = new HttpEntity(IronmanUtils.getHttpHeaders());
        restTemplate.exchange(url.build().toString(), HttpMethod.GET, entity, String.class).getBody();
        return otp;
    }

    @Override
    public void sendMessage(String mobileNo, String message){
        UriComponentsBuilder url = IronmanUtils.getUrl(sendSmsBaseUrl);
        url.path(API_KEY);
        url.path("SMS/+91");
        url.path(mobileNo+"/");
        url.path(message);
        HttpEntity entity = new HttpEntity(IronmanUtils.getHttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange(url.build().toString(), HttpMethod.GET, entity, String.class);
    }
}
