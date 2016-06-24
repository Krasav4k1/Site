package com.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Foto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String foto;


    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "publication")
    private List<Comments> commentses;

    @ManyToOne
    @JoinColumn
    private Publication publication;

    @ManyToOne
    @JoinColumn
    private AlbomFotoUser albomFotoUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Comments> getCommentses() {
        return commentses;
    }

    public void setCommentses(List<Comments> commentses) {
        this.commentses = commentses;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public AlbomFotoUser getAlbomFotoUser() {
        return albomFotoUser;
    }

    public void setAlbomFotoUser(AlbomFotoUser albomFotoUser) {
        this.albomFotoUser = albomFotoUser;
    }
}
