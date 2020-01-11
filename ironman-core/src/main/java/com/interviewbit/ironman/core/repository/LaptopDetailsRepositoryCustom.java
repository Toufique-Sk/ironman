package com.interviewbit.ironman.core.repository;

import com.interviewbit.ironman.core.models.LaptopDetails;

import java.util.List;

public interface LaptopDetailsRepositoryCustom {
    List<LaptopDetails> groupLaptopsByCity(String city);
}
