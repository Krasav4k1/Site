package com.servise.impl;

import com.entity.Country;
import com.repository.CountryRepository;
import com.servise.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    CountryRepository countryRepository;

    public Iterable<Country> getAll(){
        return countryRepository.findAll();
    }


    public Country findById(int id) {
        return countryRepository.findOne(id);
    }

    public ArrayList<Country> getAllInArrayList() {
        return countryRepository.findAllList();
    }
}
