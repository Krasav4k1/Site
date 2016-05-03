package com.servise;

import com.entity.Messages;

import java.util.List;

public interface MessageService {

    List<Messages>findMessegeByIdUserResiver(int idUserSend, int idUserResiver);

    void save(Messages messages);

}
