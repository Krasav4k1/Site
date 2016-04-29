package com.repository;

import com.entity.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Messages,Integer> {
/*
    @Query(value = "select a from Messages a where (a.userSentMessager like concat(:userSendMesseg)) and (a.userReceivedMessages like concat(:userSendMesseg))")
    Iterable<Messages> getMessegeByUserSendAndUserResived(@Param("userSendMesseg")User userSendMesseg, @Param("userReceivedMessages") User userReceivedMessages );*/

}
