package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameVideo;
    private String textFideo;
    private int longVideo;
    private int qualityVideo;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_video", joinColumns =
    @JoinColumn(name = "fk_video"), inverseJoinColumns =
    @JoinColumn(name = "fk_user"))
    private List<User> users;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "grup_video", joinColumns =
    @JoinColumn(name = "fk_video"), inverseJoinColumns =
    @JoinColumn(name = "fk_grup"))
    private List<Grup> grups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getTextFideo() {
        return textFideo;
    }

    public void setTextFideo(String textFideo) {
        this.textFideo = textFideo;
    }

    public int getLongVideo() {
        return longVideo;
    }

    public void setLongVideo(int longVideo) {
        this.longVideo = longVideo;
    }

    public int getQualityVideo() {
        return qualityVideo;
    }

    public void setQualityVideo(int qualityVideo) {
        this.qualityVideo = qualityVideo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Grup> getGrups() {
        return grups;
    }

    public void setGrups(List<Grup> grups) {
        this.grups = grups;
    }
}
