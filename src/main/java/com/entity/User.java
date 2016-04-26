package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.servise.CustomValidation.CustomValidationEmailUser;
import org.hibernate.validator.constraints.Email;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Transactional
//@PersistenceContext(type= PersistenceContextType.EXTENDED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 15, min = 2, message = "Введіть фамілію (від 2 до 15 снаків)")
    private String lastName;
    @Size(max = 15, min = 2, message = "Введіть ім'я (від 2 до 15 снаків)")
    private String firstName;
    private String password;
    @CustomValidationEmailUser(message = "Такий користувач вже існує")
    @Email(message = "Не правильно введений e-mail")
    private String email;
    private String foto;
    private int age;
    @Min(value = 1990,message = "Некорекний ввід")
    @Max(value = 2016, message = "Некорекний ввід")
    private int year;
    @Min(value = 1,message = "Некорекний ввід")
    @Max(value = 12, message = "Некорекний ввід")
    private int mouth;
    @Min(value = 1,message = "Некорекний ввід")
    @Max(value = 31, message = "Некорекний ввід")
    private int day;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    @Enumerated(EnumType.ORDINAL)
    private MaritalStatus maritalStatus;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn
    private City city;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "user")
    private List<AvatarPhoto> avatarPhotos;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "userSentMessager")
    private List<Messages> sentMessages;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "userReceivedMessages")
    private List<Messages> receivedMessages;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Publication> publications;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "user")
    private List<MusicAlbom> musicAlboms;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "user")
    private List<AlbomFotoUser> albomFotoUsers;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Language> languages;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "userSend")
    private List<Frends> sendFrendses;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "userRecived")
    private List<Frends> recivedFrendses;


    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_likes", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_avatarphoto"))
    private List<AvatarPhoto> avatarPhotosLikes;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_dislike", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_avatarphoto"))
    @JsonIgnore
    private List<AvatarPhoto> avatarPhotosDisLikes;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_commentphoto", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_avatarphoto"))
    private List<AvatarPhoto> avatarPhotosComment;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_grup", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_grup"))
    private List<Grup> grups;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_video", joinColumns =
    @JoinColumn(name = "fk_user"), inverseJoinColumns =
    @JoinColumn(name = "fk_video"))
    @JsonIgnore
    private List<Video> videos;

    public List<AvatarPhoto> getAvatarPhotosLikes() {
        return avatarPhotosLikes;
    }

    public void setAvatarPhotosLikes(List<AvatarPhoto> avatarPhotosLikes) {
        this.avatarPhotosLikes = avatarPhotosLikes;
    }

    public List<AvatarPhoto> getAvatarPhotosDisLikes() {
        return avatarPhotosDisLikes;
    }

    public void setAvatarPhotosDisLikes(List<AvatarPhoto> avatarPhotosDisLikes) {
        this.avatarPhotosDisLikes = avatarPhotosDisLikes;
    }

    public List<AvatarPhoto> getAvatarPhotosComment() {
        return avatarPhotosComment;
    }

    public void setAvatarPhotosComment(List<AvatarPhoto> avatarPhotosComment) {
        this.avatarPhotosComment = avatarPhotosComment;
    }

    public List<AvatarPhoto> getAvatarPhotos() {
        return avatarPhotos;
    }

    public void setAvatarPhotos(List<AvatarPhoto> avatarPhotos) {
        this.avatarPhotos = avatarPhotos;
    }

    public List<Frends> getSendFrendses() {
        return sendFrendses;
    }

    public void setSendFrendses(List<Frends> sendFrendses) {
        this.sendFrendses = sendFrendses;
    }

    public List<Frends> getRecivedFrendses() {
        return recivedFrendses;
    }

    public void setRecivedFrendses(List<Frends> recivedFrendses) {
        this.recivedFrendses = recivedFrendses;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

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