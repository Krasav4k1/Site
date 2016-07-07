package com.entity;

import javax.persistence.*;

@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String messager;
    @ManyToOne
    @JoinColumn
    private User userSentMessager;
    @ManyToOne
    @JoinColumn
    private User userReceivedMessages;
    private int statys;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public User getUserSentMessager() {
        return userSentMessager;
    }

    public void setUserSentMessager(User userSentMessager) {
        this.userSentMessager = userSentMessager;
    }

    public User getUserReceivedMessages() {
        return userReceivedMessages;
    }

    public void setUserReceivedMessages(User userReceivedMessages) {
        this.userReceivedMessages = userReceivedMessages;
    }

    public int getStatys() {
        return statys;
    }

    public void setStatys(int statys) {
        this.statys = statys;
    }



}
