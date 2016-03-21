package com.repository;

import com.entity.City;
import com.entity.Country;
import com.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface CityRepository extends CrudRepository<City,Integer> {


    @Query(value = "select oblast from City b where (b.country like concat(:country))")
    Set<City> findByCountry(@Param("country") int country);

    @Query(value = "select region from City c where c.oblast =:oblast")
    Set<City> findByOblast(@Param("oblast") String oblast);

    @Query(value = "select name from City c where c.region =:region")
    Set<City> findByRegion(@Param("region") String region);

    @Query(value = "select c from City c where c.name =:name")
    Set<City> findByCity(@Param("name") String name);

    @Query(value = "select region from City c where c.name =:name")
    String findRegionByName(@Param("name") String name);

    @Query(value = "select oblast from City c where c.name =:name")
    String findOblastByName(@Param("name") String name);




}



