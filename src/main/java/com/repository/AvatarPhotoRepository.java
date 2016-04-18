package com.repository;


import com.entity.AvatarPhoto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.HashSet;

public interface AvatarPhotoRepository extends CrudRepository<AvatarPhoto,Integer>{

    @Query(value = "select a from AvatarPhoto a where (a.user like concat(:userId))")
    Iterable<AvatarPhoto> findAlbomByAlbomNameAndPrincipal(@Param("userId") int userId);


    @Query(value = "select a from AvatarPhoto a where (a.user like concat(:userId)) ORDER BY id DESC ")
    ArrayList<AvatarPhoto> findAllByIdUser(@Param("userId") int userId);

    @Query(value = "select a from AvatarPhoto a where (a.user like concat(:userId)) ORDER BY id DESC ")
    AvatarPhoto findByIdUser(@Param("userId") int userId);
}
