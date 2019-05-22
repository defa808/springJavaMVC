package com.kpi.testtask2.services;

import com.kpi.testtask2.entities.Present;

import java.util.List;

public interface PresentService {
    List<Present> getAllPresent();
    Present findById(Long id);
    List<Present> findByNamePresents(String name);
    void save(Present present);
    void delete(Long id);
}
