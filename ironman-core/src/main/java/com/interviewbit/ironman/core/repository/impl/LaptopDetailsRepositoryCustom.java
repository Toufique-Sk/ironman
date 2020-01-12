package com.interviewbit.ironman.core.repository.impl;

import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.models.QLaptopDetails;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.UserDetailsRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LaptopDetailsRepositoryCustom implements com.interviewbit.ironman.core.repository.LaptopDetailsRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;
    @Autowired
    private UserDetailsRepositoryCustom userDetailsRepositoryCustom;

    private List<LaptopDetails> laptopByCity;

    @Override
    public List<LaptopDetails> groupLaptopsByCity(String city)
    {

        List<String> userIdDetail = userDetailsRepositoryCustom.getAllUserDetailByCity(city);
        QLaptopDetails laptopDetail = QLaptopDetails.laptopDetails;

        for(int i=0;i<userIdDetail.size();i++)
        {
            List<LaptopDetails> singleLaptopDetail = queryFactory.select(laptopDetail).where(laptopDetail.userId.eq(userIdDetail.get(i))).fetch();
            for(int j=0;j<singleLaptopDetail.size();j++)
            {
                laptopByCity.add(singleLaptopDetail.get(j));
            }
        }
        return laptopByCity;
    }


}
