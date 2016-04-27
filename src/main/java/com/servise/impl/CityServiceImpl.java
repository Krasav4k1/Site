package com.servise.impl;

import com.entity.City;
import com.repository.CityRepository;
import com.servise.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

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

    public City findCity(int id){
        return cityRepository.findOne(id);
    }

}
