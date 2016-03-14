package com.repository;

import com.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CountryRepository extends CrudRepository<Country,Integer>{

    @Query(value = "select u from Country u where u.id = ?1")
    Country findUserById (@RequestParam int id);

}
