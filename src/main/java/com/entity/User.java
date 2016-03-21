package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String foto;
    private int age;
    private int statys;
    private int year;
    private int mouth;
    private int day;
    private int onlineUser;
    private int statuFrendship;
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @ManyToOne
    @JoinColumn
    private City city;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userSentMessager")
    private List<Messages> sentMessages;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userReceivedMessages")
    private List<Messages> receivedMessages;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Publication> publications;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<MusicAlbom> musicAlboms;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<AlbomFotoUser> albomFotoUsers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_grup", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_grup"))
    private List<Grup> grups;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_video", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_video"))
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    public List<AlbomFotoUser> getAlbomFotoUsers() {
        return albomFotoUsers;
    }

    public void setAlbomFotoUsers(List<AlbomFotoUser> albomFotoUsers) {
        this.albomFotoUsers = albomFotoUsers;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatys() {
        return statys;
    }

    public void setStatys(int statys) {
        this.statys = statys;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Messages> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Messages> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Messages> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Messages> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Grup> getGrups() {
        return grups;
    }

    public void setGrups(List<Grup> grups) {
        this.grups = grups;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public int getStatuFrendship() {
        return statuFrendship;
    }

    public void setStatuFrendship(int statuFrendship) {
        this.statuFrendship = statuFrendship;
    }

    public int getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(int onlineUser) {
        this.onlineUser = onlineUser;
    }

    public List<MusicAlbom> getMusicAlboms() {
        return musicAlboms;
    }

    public void setMusicAlboms(List<MusicAlbom> musicAlboms) {
        this.musicAlboms = musicAlboms;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}