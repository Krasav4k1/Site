package com.servise;

import com.entity.City;
import com.entity.Country;
import com.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public Iterable<City> getAll(){
        return cityRepository.findAll();
    }

    public Iterable<City> getOblast(int id){
        return cityRepository.findByCountry(id);
    }

    public Iterable<City> getRegion(String oblast){
        return cityRepository.findByOblast(oblast);
    }

    public Iterable<City> getCity(String region){
        return cityRepository.findByRegion(region);
    }

}
