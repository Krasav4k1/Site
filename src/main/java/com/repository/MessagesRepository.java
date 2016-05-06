package com.repository;

import com.entity.Messages;
import com.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Messages,Integer> {

    @Query(value = "select a from Messages a where (a.userSentMessager = ?1 and a.userReceivedMessages = ?2) or (a.userSentMessager = ?2 and a.userReceivedMessages = ?1) ORDER BY id DESC")
    List<Messages> getMessegeByUserSendAndUserResived(User userSendMesseg, User userReceivedMessages);

}
