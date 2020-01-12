package com.interviewbit.ironman.dtos;

import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
public class LaptopDetailsDto {

    private String seriallNo;

    private String userId;

    private String laptopBrand;

    private Integer ram;

    private String processor;

    private String ssd;

    private String hdd;

    private Integer rentPrice;

    public String getSeriallNo() {
        return seriallNo;
    }

    public void setSeriallNo(String seriallNo) {
        this.seriallNo = seriallNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLaptopBrand() {
        return laptopBrand;
    }

    public void setLaptopName(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }
}

