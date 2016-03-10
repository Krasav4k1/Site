package com.repository;

import com.entity.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Messages,Integer> {
}
