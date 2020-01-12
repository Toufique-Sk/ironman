package com.interviewbit.ironman.dtos;

import java.util.Date;

/**
 * Created by Toufique on 11/1/20.
 */
public class RentDto {
    private String BorrowerId;

    private String laptopId;

    private Date tentetiveLendingDate;

    private Date tentativereturnDate;

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public Date getTentetiveLendingDate() {
        return tentetiveLendingDate;
    }

    public void setTentetiveLendingDate(Date tentetiveLendingDate) {
        this.tentetiveLendingDate = tentetiveLendingDate;
    }

    public Date getTentativereturnDate() {
        return tentativereturnDate;
    }

    public void setTentativereturnDate(Date tentativereturnDate) {
        this.tentativereturnDate = tentativereturnDate;
    }

    public String getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(String BorrowerId) {
        this.BorrowerId = BorrowerId;
    }
}
