package com.servise.impl;

import com.entity.Messages;
import com.entity.User;
import com.repository.MessagesRepository;
import com.repository.UserRepository;
import com.servise.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    UserRepository userRepository;


    public List<Messages> findMessegeByIdUserResiver(int idUserSend, int idUserResiver){
        User userSend = userRepository.findOne(idUserSend);
        User userRecived = userRepository.findOne(idUserResiver);
        return messagesRepository.getMessegeByUserSendAndUserResived(userSend,userRecived);
}

    public void save(Messages messages){
        messagesRepository.save(messages);
    }

}
