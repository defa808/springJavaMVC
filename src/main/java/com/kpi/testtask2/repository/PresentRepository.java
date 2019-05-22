package com.kpi.testtask2.repository;

import com.kpi.testtask2.entities.Present;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PresentRepository extends CrudRepository<Present, Long> {
    List<Present> findByName(String name);

}
