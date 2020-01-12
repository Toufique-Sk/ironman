package com.interviewbit.ironman.service;

public interface SendMessageService {
    String sendOtp(String mobileNo);
    void sendMessage(String mobileNo, String message);
}
