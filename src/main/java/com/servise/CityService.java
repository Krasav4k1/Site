package com.servise;

import com.entity.City;
import com.entity.Country;
import com.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public Iterable<City> getAll(){
        return cityRepository.findAll();
    }


}
