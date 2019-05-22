package com.kpi.testtask2.entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
public class Sweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Sweet(){}

    public Sweet(String name, String developerName, Date shelfLife) {
        this.name = name;
        this.developerName = developerName;
        this.shelfLife = shelfLife;
    }

    private String name;
    private String developerName;
    private Date shelfLife;

    @ManyToOne
    @JoinColumn
    private Present present;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sweet)) return false;
        Sweet sweet = (Sweet) o;
        return Objects.equals(id, sweet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + id.toString());
    }

}
