package com.interviewbit.ironman.core.repository;

public interface UserDetailsRepositoryCustom {

    public void updateAccountStatus(String userId);

    public String findByMobileNo(String mobileNo);
}
