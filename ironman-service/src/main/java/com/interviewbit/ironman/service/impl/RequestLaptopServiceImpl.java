package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.common.exceptions.IronmanRuntimeException;
import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.models.RequestDetails;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.LaptopDetailsRepository;
import com.interviewbit.ironman.core.repository.RequestDetailsRepository;
import com.interviewbit.ironman.core.repository.RequestDetailsRepositoryCustom;
import com.interviewbit.ironman.core.repository.UserDetailsRepository;
import com.interviewbit.ironman.dtos.LaptopDetailsDto;
import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.dtos.RequestListOfUser;
import com.interviewbit.ironman.dtos.enums.LendStatus;
import com.interviewbit.ironman.service.RequestLaptopService;
import com.interviewbit.ironman.service.SendMessageService;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Toufique on 11/1/20.
 */

@Service
public class RequestLaptopServiceImpl implements RequestLaptopService{

    @Autowired
    private LaptopDetailsRepository laptopDetailsRepository;

    @Autowired
    private RequestDetailsRepository requestDetailsRepository;

    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private RequestDetailsRepositoryCustom requestDetailsRepositoryCustom;


    @Override
    public void requestLaptop(RentDto rentDto) {
        Optional<LaptopDetails> lenderId = laptopDetailsRepository.findById(rentDto.getLaptopId());
        if(!lenderId.isPresent()){
            throw new IronmanRuntimeException("Err-108", "Lender is not present");
        }
        RequestDetails requestDetails = new RequestDetails();
        requestDetails.setBorrowerId(rentDto.getBorrowerId());
        requestDetails.setLaptopId(rentDto.getLaptopId());
        requestDetails.setLendStatus(LendStatus.PENDING);
        requestDetails.setReturnDate(rentDto.getTentativereturnDate());
        requestDetails.setRentDate(rentDto.getTentetiveLendingDate());
        requestDetails.setUserId(lenderId.get().getUserId());
        requestDetailsRepository.save(requestDetails);
        //Optional<UserDetails> userDetails = userDetailsRepository.findById(lenderId.get().getUserId());

        //sendMessageService.sendMessage(userDetails.get().getMobileNo(), "Book";

    }

    @Override
    public List<RequestListOfUser> getLaptopRequestListByUser(String userId) {
        List<RequestDetails> requestDetailsList = requestDetailsRepositoryCustom.getRequestDetailsByUserid(userId);

        List<RequestListOfUser> requestListOfUserList = new ArrayList<>();
        for(RequestDetails requestDetails : requestDetailsList){
            Optional<LaptopDetails> laptopDetails = laptopDetailsRepository.findById(requestDetails.getLaptopId());
            RequestListOfUser requestListOfUser = new RequestListOfUser();
            requestListOfUser.setBorrowerId(requestDetails.getBorrowerId());
            requestListOfUser.setLaptopBrand(laptopDetails.get().getLaptopBrand());
                LaptopDetailsDto laptopDetailsDto = new LaptopDetailsDto();
                laptopDetailsDto.setHdd(laptopDetails.get().getHdd());
                laptopDetailsDto.setLaptopName(laptopDetails.get().getLaptopBrand());
                laptopDetailsDto.setProcessor(laptopDetails.get().getProcessor());
                laptopDetailsDto.setRam(laptopDetails.get().getRam());
                laptopDetailsDto.setRentPrice(laptopDetails.get().getPrice());
                laptopDetailsDto.setSeriallNo(laptopDetails.get().getSeriallNo());
                laptopDetailsDto.setSsd(laptopDetails.get().getSsd());
                laptopDetailsDto.setUserId(userId);
            requestListOfUser.setLaptopDetailsDto(laptopDetailsDto);
            requestListOfUser.setLendStatus(requestDetails.getLendStatus());
            requestListOfUserList.add(requestListOfUser);
        }

        return requestListOfUserList;

    }

    @Override
    public String modifyRequest(Long id, String lenderId, LendStatus lendStatus) {
        requestDetailsRepositoryCustom.updateLendingStatus(id, lendStatus);
        Optional<RequestDetails> requestDetails = requestDetailsRepository.findById(String.valueOf(id));
        if(requestDetails.get().getLendStatus().equals(LendStatus.ACCEPTED))
            autoReject(requestDetails.get().getRentDate(), requestDetails.get().getReturnDate(), id, requestDetails.get().getUserId());
        return requestDetails.get().getBorrowerId() + "'s request is "+ requestDetails.get().getLendStatus();
    }

    private void autoReject(Date startDate, Date returnDate, Long id, String userId){
        requestDetailsRepositoryCustom.autoReject(startDate,returnDate, id, userId);
    }

}
