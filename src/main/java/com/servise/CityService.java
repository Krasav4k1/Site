package com.servise;

import com.entity.City;

public interface CityService {

    Iterable<City> getAll();

    Iterable<City> getOblast(int id);

    Iterable<City> getRegion(String oblast);

    Iterable<City> getCity(String region);

    City findCity(int id);

}
