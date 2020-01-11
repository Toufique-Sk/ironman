package com.interviewbit.ironman.core.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
@Entity
@Table(name ="IB_LAPTOP_DETAILS")
public class LaptopDetails {

    @Id
    @Column(name = "SERIAL_NO")
    private String seriallNo;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "LAPTOP_NAME")
    private String laptopName;

    @Column(name = "RAM")
    private String ram;

    @Column(name = "PROCESSOR")
    private String processor;

    @Column(name = "SSD")
    private String ssd;

    @Column(name = "HDD")
    private String hdd;

    @Column(name = "PRICE")
    private Integer price;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "IMAGE_ONE_ID")
    private String imageOneId;

    @Column(name = "IMAGE_TWO_ID")
    private String imageTwoId;

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

    public String getImageOneId() {
        return imageOneId;
    }

    public void setImageOneId(String imageOneId) {
        this.imageOneId = imageOneId;
    }

    public String getImageTwoId() {
        return imageTwoId;
    }

    public void setImageTwoId(String imageTwoId) {
        this.imageTwoId = imageTwoId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
