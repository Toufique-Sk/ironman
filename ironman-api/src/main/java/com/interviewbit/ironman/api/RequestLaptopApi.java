package com.interviewbit.ironman.api;

import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.dtos.RequestListOfUser;
import com.interviewbit.ironman.dtos.enums.LendStatus;
import com.interviewbit.ironman.service.RequestLaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Toufique on 11/1/20.
 */
@RestController
@RequestMapping("/request")
public class RequestLaptopApi {

    @Autowired
    private RequestLaptopService requestLaptopService;

    @PostMapping("/postRequest")
    public ResponseEntity requestYourLaptop(@RequestBody RentDto rentDto){
        requestLaptopService.requestLaptop(rentDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listRequest/{userId}")
    public ResponseEntity<List<RequestListOfUser>> getLaptopRequestList(@PathVariable("userId") String userId){
        List<RequestListOfUser> requestListOfUser = requestLaptopService.getLaptopRequestListByUser(userId);
        return ResponseEntity.ok(requestListOfUser);
    }

    @PostMapping("/modify-request/{id}/{lenderId}/{status}")
    public ResponseEntity modifyRequest(@PathVariable("id") Long id ,@PathVariable("lenderId") String lenderId, @PathVariable("status")LendStatus lendStatus){
        String response = requestLaptopService.modifyRequest(id, lenderId, lendStatus);
        return ResponseEntity.ok(response);
    }
}
