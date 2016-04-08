package com.repository;

import com.entity.AlbomFotoUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlbomFotoUserRepository extends CrudRepository<AlbomFotoUser,Integer> {

    @Query(value = "select a from AlbomFotoUser a where (a.albomName LIKE concat(:nameAlbom)) and (a.user like concat(:userId))")
    AlbomFotoUser findAlbomByAlbomNameAndPrincipal(@Param("nameAlbom") String nameAlbom,@Param("userId") int userId);

    @Query(value = "select a from AlbomFotoUser a where  (a.user like concat(:userId))")
    Iterable<AlbomFotoUser> getAllAlbomFotoByUserId(@Param("userId") int userId);

}
