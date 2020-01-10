package com.interviewbit.ironman.core.models;

import com.interviewbit.ironman.dtos.enums.LendStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
@Entity
@Table(name = "IB_LENNDER_LENDING_DETAILS")
public class LenderLendingDetails {

    @Column(name = "LAPTOP_ID")
    private String laptopId;

    @Column(name = "BORROWER_ID")
    private String borrowerId;

    @Column(name = "BORROWER_MOBILE_NO")
    private String borrowerMobileNo;

    @Column(name = "TENTATIVE_BORROWING_DATE")
    private Date tentativeBorrowingDate;

    @Column(name = "TENTATIVE_RETURN_Date")
    private String tentativeReturnDate;

    @Column(name = "STATUS")
    private LendStatus lendStatus;

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getTentativeBorrowingDate() {
        return tentativeBorrowingDate;
    }

    public void setTentativeBorrowingDate(Date tentativeBorrowingDate) {
        this.tentativeBorrowingDate = tentativeBorrowingDate;
    }

    public String getTentativeReturnDate() {
        return tentativeReturnDate;
    }

    public void setTentativeReturnDate(String tentativeReturnDate) {
        this.tentativeReturnDate = tentativeReturnDate;
    }

    public LendStatus getLendStatus() {
        return lendStatus;
    }

    public void setLendStatus(LendStatus lendStatus) {
        this.lendStatus = lendStatus;
    }

    public String getBorrowerMobileNo() {
        return borrowerMobileNo;
    }

    public void setBorrowerMobileNo(String borrowerMobileNo) {
        this.borrowerMobileNo = borrowerMobileNo;
    }
}
