package com.entity;

import com.servise.CustomValidation.CustomValidNameAlbom;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
public class AlbomFotoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "^/p/(?<secure>[\\w\\-=]+,\\d+),(?<user>[^/]+)(?<file>/.*)$")
    @CustomValidNameAlbom(message = "такий альбом вже існує")
    private String albomName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "albomFotoUser")
    private List<Foto> fotos;

    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Grup grup;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbomName() {
        return albomName;
    }

    public void setAlbomName(String albomName) {
        this.albomName = albomName;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
}
