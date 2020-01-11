package com.interviewbit.ironman.api;

import com.interviewbit.ironman.dtos.LaptopDetailsDto;
import com.interviewbit.ironman.service.ListYourLaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Toufique on 11/1/20.
 */
@RestController
@RequestMapping("/list")
public class ListYourLaptopApi {

    @Autowired
    private ListYourLaptopService listYourLaptopService;

    @PostMapping("/list-laptop")
    public ResponseEntity<String> listLaptop(@RequestBody LaptopDetailsDto laptopDetailsDto){
        String response = listYourLaptopService.listYourLaptop(laptopDetailsDto);
        return ResponseEntity.ok(response);
    }
}
