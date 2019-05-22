package com.kpi.testtask2.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Data
public class Present {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Present(){}

    public Present(String name, Sweet... sweets) {
        this.name = name;
        this.sweets = Stream.of(sweets).collect(Collectors.toSet());
        this.sweets.forEach(x -> x.setPresent(this));
    }

    @OneToMany(mappedBy = "present", cascade = CascadeType.ALL)
    private Set<Sweet> sweets;
}
