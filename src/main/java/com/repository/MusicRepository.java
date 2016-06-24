package com.repository;

import com.entity.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music,Integer> {
}
