package com.entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Transactional
public class AvatarPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foto;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn
    private User user;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_likes", joinColumns =
    @JoinColumn(name = "fk_avatarphoto"), inverseJoinColumns =
    @JoinColumn(name = "fk_user"))
    @JsonIgnore
    private List<User> usersLikePhoto;


    private int countLike;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_disLike", joinColumns =
    @JoinColumn(name = "fk_avatarphoto"), inverseJoinColumns =
    @JoinColumn(name = "fk_user"))
    @JsonIgnore
    private List<User> usersDisLikePhoto;

    private int countDisLike;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "user_commentphoto", joinColumns =
    @JoinColumn(name = "fk_avatarphoto"), inverseJoinColumns =
    @JoinColumn(name = "fk_user"))
    @JsonIgnore
    private List<User> usersCommentPhoto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    private String comment;

    private int couuntComents;

    public int getCountDisLike() {
        return countDisLike;
    }

    public void setCountDisLike(int countDisLike) {
        this.countDisLike = countDisLike;
    }

    public int getCouuntComents() {
        return couuntComents;
    }

    public void setCouuntComents(int couuntComents) {
        this.couuntComents = couuntComents;
    }

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsersLikePhoto() {
        return usersLikePhoto;
    }

    public void setUsersLikePhoto(List<User> usersLikePhoto) {
        this.usersLikePhoto = usersLikePhoto;
    }


    public List<User> getUsersDisLikePhoto() {
        return usersDisLikePhoto;
    }

    public void setUsersDisLikePhoto(List<User> usersDisLikePhoto) {
        this.usersDisLikePhoto = usersDisLikePhoto;
    }


    public List<User> getUsersCommentPhoto() {
        return usersCommentPhoto;
    }

    public void setUsersCommentPhoto(List<User> usersCommentPhoto) {
        this.usersCommentPhoto = usersCommentPhoto;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
