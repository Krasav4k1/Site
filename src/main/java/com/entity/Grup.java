package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Grup {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String nameGrup;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "grup")
    private List<Publication> publications;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "grup")
    private List<MusicAlbom> musicAlboms;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "grup")
    private List<AlbomFotoUser> albomFotoUsers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_grup", joinColumns =
    @JoinColumn(name = "fk_grup"), inverseJoinColumns =
    @JoinColumn(name = "fk_user"))
    private List<User> users;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "grup_video", joinColumns =
    @JoinColumn(name = "fk_grup"), inverseJoinColumns =
    @JoinColumn(name = "fk_video"))
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGrup() {
        return nameGrup;
    }

    public List<AlbomFotoUser> getAlbomFotoUsers() {
        return albomFotoUsers;
    }

    public void setAlbomFotoUsers(List<AlbomFotoUser> albomFotoUsers) {
        this.albomFotoUsers = albomFotoUsers;
    }

    public void setNameGrup(String nameGrup) {
        this.nameGrup = nameGrup;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public List<MusicAlbom> getMusicAlboms() {
        return musicAlboms;
    }

    public void setMusicAlboms(List<MusicAlbom> musicAlboms) {
        this.musicAlboms = musicAlboms;
    }
}
