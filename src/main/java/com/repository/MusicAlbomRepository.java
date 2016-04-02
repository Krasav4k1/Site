package com.repository;

import com.entity.MusicAlbom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MusicAlbomRepository extends CrudRepository<MusicAlbom,Integer> {

}
