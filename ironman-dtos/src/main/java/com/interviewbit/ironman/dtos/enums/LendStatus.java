package com.interviewbit.ironman.dtos.enums;

/**
 * Created by Toufique on 11/1/20.
 */
public enum LendStatus {
    PENDING("Pending"),
    REJECTED("Rejected"),
    ACCEPTED("Accepted");

    private String value;

    LendStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
