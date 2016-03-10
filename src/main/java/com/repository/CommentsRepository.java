package com.repository;

import com.entity.Comments;
import org.springframework.data.repository.CrudRepository;

public interface CommentsRepository extends CrudRepository<Comments,Integer> {
}
