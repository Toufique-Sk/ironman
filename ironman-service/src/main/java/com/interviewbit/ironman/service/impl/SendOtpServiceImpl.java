package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.service.SendOtpService;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SendOtpServiceImpl implements SendOtpService {

    public String sendOtp(String mobileNo){
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("e1c243a9")
                .apiSecret("6D1S7MKWCpkLh6bt")
                .build();
        String messageText = getOtp();
        TextMessage message = new TextMessage("rentOlap", "mobileNo", messageText);

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
        return messageText;
    }

    private String getOtp(){
        Random randomNumber = new Random();
        return String.valueOf(randomNumber.nextInt((9999 - 1000) + 1));
    }
}
