package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class MusicAlbom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameAlbom;
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Grup grup;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "musicAlbom_music", joinColumns =
    @JoinColumn(name = "fk_musicAlbom"), inverseJoinColumns =
    @JoinColumn(name = "fk_music"))
    private List<Music> musics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAlbom() {
        return nameAlbom;
    }

    public void setNameAlbom(String nameAlbom) {
        this.nameAlbom = nameAlbom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }
}
