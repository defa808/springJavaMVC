package com.kpi.testtask2.services;


import com.kpi.testtask2.entities.Sweet;

import java.util.List;

public interface SweetService {
    List<Sweet> getAllSweets();
    Sweet findById(Long id);
    List<Sweet> findByName(String name);
    void save(Sweet sweet);
    void delete(Long id);
}