package com.kpi.testtask2.repository;

import com.kpi.testtask2.entities.Sweet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SweetRepository extends CrudRepository<Sweet, Long> {
        List<Sweet> findByName(String name);

}