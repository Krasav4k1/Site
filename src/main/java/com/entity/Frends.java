package com.entity;

import javax.persistence.*;

@Entity
public class Frends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sendFrendship;
    private int recivedFrendsip;
    private int spesialStatys;

    @ManyToOne
    @JoinColumn
    private User userSend;

    @ManyToOne
    @JoinColumn
    private User userRecived;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSendFrendship() {
        return sendFrendship;
    }

    public void setSendFrendship(int sendFrendship) {
        this.sendFrendship = sendFrendship;
    }

    public int getRecivedFrendsip() {
        return recivedFrendsip;
    }

    public void setRecivedFrendsip(int recivedFrendsip) {
        this.recivedFrendsip = recivedFrendsip;
    }

    public int getSpesialStatys() {
        return spesialStatys;
    }

    public void setSpesialStatys(int spesialStatys) {
        this.spesialStatys = spesialStatys;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserRecived() {
        return userRecived;
    }

    public void setUserRecived(User userRecived) {
        this.userRecived = userRecived;
    }


}
