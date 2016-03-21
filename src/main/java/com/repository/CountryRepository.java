package com.repository;

import com.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface CountryRepository extends CrudRepository<Country,Integer>{


    @Query(value = "select name from Country c where c.id =:id")
    String findCountryById(@Param("id") int id);


}
