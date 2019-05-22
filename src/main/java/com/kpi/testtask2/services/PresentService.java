package com.kpi.testtask2.services;

import com.kpi.testtask2.entities.Present;

import java.util.List;

public interface PresentService {
    List<Present> getAllPresent();
    List<Present> findByNamePresents(String name);
    void savePresent(Present present);
}
