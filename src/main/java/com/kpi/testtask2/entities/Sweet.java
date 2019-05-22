package com.kpi.testtask2.entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Sweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Sweet(){}

    public Sweet(String name, String developerName) {
        this.name = name;
        this.developerName = developerName;
    }

    private String name;
    private String developerName;

    @ManyToOne
    @JoinColumn
    private Present present;

}
