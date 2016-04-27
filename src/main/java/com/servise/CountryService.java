package com.servise;

import com.entity.Country;

import java.util.ArrayList;


public interface CountryService {

    Iterable<Country> getAll();

    Country findById(int id);

    ArrayList<Country> getAllInArrayList();

}
