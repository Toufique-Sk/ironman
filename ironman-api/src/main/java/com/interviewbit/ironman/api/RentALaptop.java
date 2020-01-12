package com.interviewbit.ironman.api;

import com.interviewbit.ironman.core.models.LaptopDetails;
import com.interviewbit.ironman.core.models.QLaptopDetails;
import com.interviewbit.ironman.core.repository.impl.LaptopDetailsRepositoryCustom;
import com.interviewbit.ironman.service.impl.RentALaptopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/filter")
public class RentALaptop {

    @Autowired
    RentALaptopServiceImpl rentALaptopServiceImpl;

    @GetMapping("/city")
    public List<LaptopDetails> getLaptopByCity(String city)
    {
        List<LaptopDetails> laptopByCity = new ArrayList<>();
        laptopByCity = rentALaptopServiceImpl.findAllCity(city);
        return  laptopByCity;
    }

    @GetMapping("/processor")
    public List<LaptopDetails> getProcessor(String processor)
    {
        List<LaptopDetails> processorFilter = new ArrayList<>();
        processorFilter = rentALaptopServiceImpl.filterByProcessor(processor);
        return processorFilter;
    }

    @GetMapping("/ram")
    public List<LaptopDetails> getRam(int Ram)
    {
        List<LaptopDetails> ramFilter = new ArrayList<>();
        ramFilter = rentALaptopServiceImpl.filterByRam(Ram);
        return ramFilter;
    }

}
