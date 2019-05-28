package com.kpi.testtask2.services;

public interface ServiceBase<T extends Object> {
    T findById(Long id);
    void save(T present);
    void delete(Long id);
}
