package com.servise;

import com.entity.Messages;

public interface MessageService {

    Iterable<Messages> findMessegeByIdUserResiver(int idUserSend, int idUserResiver);

    void save(Messages messages);

}
