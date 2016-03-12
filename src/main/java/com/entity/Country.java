package com.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    private List<Oblast> oblasts;

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

    public List<Oblast> getOblasts() {
        return oblasts;
    }

    public void setOblasts(List<Oblast> oblasts) {
        this.oblasts = oblasts;
    }




}
