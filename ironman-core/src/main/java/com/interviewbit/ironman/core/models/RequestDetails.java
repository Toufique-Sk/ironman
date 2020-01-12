package com.interviewbit.ironman.core.models;

import com.interviewbit.ironman.dtos.enums.LendStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
@Entity
@Table(name = "IB_REQUEST_DETAILS")
public class RequestDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "BORROWER_ID")
    private String borrowerId;

    @Column(name = "LAPTOP_ID")
    private String laptopId;

    @Column(name = "RETURN_DATE" )
    private Date returnDate;

    @Column(name = "REQUEST_STATUS")
    private LendStatus lendStatus;

    @Column(name = "RENTING_DATE")
    private Date rentDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public LendStatus getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(LendStatus lendStatus) {
        this.lendStatus = lendStatus;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }
}
