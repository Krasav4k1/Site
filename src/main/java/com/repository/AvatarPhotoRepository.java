package com.repository;


import com.entity.AlbomFotoUser;
import com.entity.AvatarPhoto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AvatarPhotoRepository extends CrudRepository<AvatarPhoto,Integer>{

    @Query(value = "select a from AvatarPhoto a where (a.user like concat(:userId))")
    Iterable<AvatarPhoto> findAlbomByAlbomNameAndPrincipal(@Param("userId") int userId);


    @Query(value = "select a from AvatarPhoto a where (a.user like concat(:userId))")
    Iterable<AvatarPhoto> findAllByIdUser(@Param("userId") int userId);
}
