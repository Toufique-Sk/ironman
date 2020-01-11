package com.interviewbit.ironman.dtos;

import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
public class LaptopDetailsDto {

    private String userId;

    private String laptopName;

    private String seriallNo;

    private String ram;

    private String processor;

    private String ssd;

    private String hdd;

    private Integer price;

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getSeriallNo() {
        return seriallNo;
    }

    public void setSeriallNo(String seriallNo) {
        this.seriallNo = seriallNo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

