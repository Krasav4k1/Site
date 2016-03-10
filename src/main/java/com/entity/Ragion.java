package com.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Ragion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ragion")
    private List<City> citys;
    @ManyToOne
    private Oblast oblast;

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

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    public Oblast getOblast() {
        return oblast;
    }

    public void setOblast(Oblast oblast) {
        this.oblast = oblast;
    }


}
