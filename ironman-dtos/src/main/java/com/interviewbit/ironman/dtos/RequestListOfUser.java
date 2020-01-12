package com.interviewbit.ironman.dtos;

import com.interviewbit.ironman.dtos.enums.LendStatus;

/**
 * Created by Toufique on 12/1/20.
 */
public class RequestListOfUser {

    private LaptopDetailsDto laptopDetailsDto;
    private String BorrowerId;
    private String laptopBrand;
    private LendStatus lendStatus;

    public LaptopDetailsDto getLaptopDetailsDto() {
        return laptopDetailsDto;
    }

    public void setLaptopDetailsDto(LaptopDetailsDto laptopDetailsDto) {
        this.laptopDetailsDto = laptopDetailsDto;
    }

    public String getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        BorrowerId = borrowerId;
    }

    public String getLaptopBrand() {
        return laptopBrand;
    }

    public void setLaptopBrand(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }

    public LendStatus getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(LendStatus lendStatus) {
        this.lendStatus = lendStatus;
    }
}
