package com.interviewbit.ironman.service.impl;

import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.models.UserDetails;
import com.interviewbit.ironman.core.repository.LaptopDetailsRepository;
import com.interviewbit.ironman.core.repository.RentDetailsRepository;
import com.interviewbit.ironman.core.repository.UserDetailsRepository;
import com.interviewbit.ironman.dtos.RentDto;
import com.interviewbit.ironman.service.RentALaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import com.interviewbit.ironman.core.repository.impl.LaptopDetailsRepositoryCustom;
import java.util.List;
import java.util.Optional;

/**
 * Created by Toufique on 11/1/20.
 */
public class RentALaptopServiceImpl  implements RentALaptopService{

    @Autowired
    private RentDetailsRepository rentDetailsRepository;

    @Autowired
    private LaptopDetailsRepository laptopDetailsRepository;

    @Autowired
    private LaptopDetailsRepositoryCustom laptopDetailsRepositoryCustom;

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Override
    public String requestLaptop(RentDto rentDto) {
        Optional<LaptopDetails> laptopDetails = laptopDetailsRepository.findById(rentDto.getLaptopId());
        Optional<UserDetails> lenderDetails = userDetailsRepository.findById(laptopDetails.get().getUserId());
        return null;
    }

    @Override
    public String rentApproved(String borrowerUserId) {
        return null;
    }

    private List<LaptopDetails> laptopByCity;

    public List<LaptopDetails> findAllCity(String city)
    {
        laptopByCity = laptopDetailsRepositoryCustom.groupLaptopsByCity(city);
        return laptopByCity;
    }

    @Override
    public List<LaptopDetails> filterByProcessor(String processor)
    {

        for(int i=0;i<laptopByCity.size();i++)
        {
            int requiredProcessor = (int)(processor.charAt(1));
            int actualProcessor = (int)(laptopByCity.get(i).getProcessor().charAt(1));
            if(requiredProcessor>actualProcessor)
            {
                laptopByCity.remove(i);
            }
        }
        return laptopByCity;
    }
    @Override
    public List<LaptopDetails> filterByRam(int ram)
    {
        for(int i=0;i<laptopByCity.size();i++)
        {
            if(ram>laptopByCity.get(i).getRam())
            {
                laptopByCity.remove(i);
            }
        }
        return laptopByCity;
    }

}
