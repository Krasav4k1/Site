package com.repository;

import com.entity.Foto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FotoRepository extends CrudRepository<Foto,Integer>{

    @Query(value = "select a from Foto a where (a.albomFotoUser like concat(:albomFoto))")
    Iterable<Foto> getAllFotoFromAlbom (@Param("albomFoto") int albomFoto);

    @Query(value = "select a from Foto a where (a.foto like concat(:foto)) and (a.albomFotoUser like concat(:albomFoto))")
    Foto getDefaultFoto (@Param("foto") String foto, @Param("albomFoto") int albomFoto);
}
