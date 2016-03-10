package com.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Oblast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "oblast")
    private List<Ragion> ragions;
    @ManyToOne
    @JoinColumn
    private Country country;

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

    public List<Ragion> getRagions() {
        return ragions;
    }

    public void setRagions(List<Ragion> ragions) {
        this.ragions = ragions;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


}
