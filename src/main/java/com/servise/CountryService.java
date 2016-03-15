package com.servise;

import com.entity.City;
import com.entity.Country;
import com.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public Iterable<Country> getAll(){
        return countryRepository.findAll();
    }
}
