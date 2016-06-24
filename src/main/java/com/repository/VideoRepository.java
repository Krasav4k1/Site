package com.repository;

import com.entity.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video,Integer> {
}
