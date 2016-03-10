package com.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    @ManyToOne
    @JoinColumn
    private Ragion ragion;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
    private List<User> user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ragion getRagion() {
        return ragion;
    }

    public void setRagion(Ragion ragion) {
        this.ragion = ragion;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }


}
