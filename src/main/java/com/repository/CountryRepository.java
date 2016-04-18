package com.repository;

import com.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public interface CountryRepository extends CrudRepository<Country,Integer>{

    @Query(value = "SELECT a from Country a")
    ArrayList<Country> findAllList();
}
