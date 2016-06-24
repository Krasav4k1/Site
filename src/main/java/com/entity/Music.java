package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameMusic;
    private String authorMusic;
    private int longMusic;
    private int qualityMusic;
    private String textMusic;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "musicAlbom_music", joinColumns =
    @JoinColumn(name = "fk_music"), inverseJoinColumns =
    @JoinColumn(name = "fk_musicAlbom"))
    private List<MusicAlbom> musicAlboms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getAuthorMusic() {
        return authorMusic;
    }

    public void setAuthorMusic(String authorMusic) {
        this.authorMusic = authorMusic;
    }

    public int getLongMusic() {
        return longMusic;
    }

    public void setLongMusic(int longMusic) {
        this.longMusic = longMusic;
    }

    public int getQualityMusic() {
        return qualityMusic;
    }

    public void setQualityMusic(int qualityMusic) {
        this.qualityMusic = qualityMusic;
    }

    public String getTextMusic() {
        return textMusic;
    }

    public void setTextMusic(String textMusic) {
        this.textMusic = textMusic;
    }

    public List<MusicAlbom> getMusicAlboms() {
        return musicAlboms;
    }

    public void setMusicAlboms(List<MusicAlbom> musicAlboms) {
        this.musicAlboms = musicAlboms;
    }
}
