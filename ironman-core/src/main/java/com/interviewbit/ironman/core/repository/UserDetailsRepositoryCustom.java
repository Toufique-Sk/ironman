package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.UserDetails;

import java.util.List;

public interface UserDetailsRepositoryCustom {

    public void updateAccountStatus(String userId);

    public String findByMobileNo(String mobileNo);

    List<String> getAllUserDetailByCity(String city);
}

