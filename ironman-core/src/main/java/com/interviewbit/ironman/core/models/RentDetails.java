package com.interviewbit.ironman.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Toufique on 11/1/20.
 */

@Entity
@Table(name = "IB_LENDING_TABLE")
public class RentDetails {

    @Column(name = "LAPTOP_ID")
    private String LaptopId;

    @Column(name = "OWNER_USER_ID")
    private String ownerUserId;

    @Column(name ="BORROWER_USER_ID")
    private String borrowerUserId;

    public String getLaptopId() {
        return LaptopId;
    }

    public void setLaptopId(String laptopId) {
        LaptopId = laptopId;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public String getBorrowerUserId() {
        return borrowerUserId;
    }

    public void setBorrowerUserId(String borrowerUserId) {
        this.borrowerUserId = borrowerUserId;
    }
}
