package com.entity;

import javax.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String comments;

    @ManyToOne
    @JoinColumn
    private Publication publication;

    @ManyToOne
    @JoinColumn
    private Foto foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
}
