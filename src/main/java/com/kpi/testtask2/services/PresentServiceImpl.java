package com.kpi.testtask2.services;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.assertj.core.util.Lists;

import java.util.List;

@Service
public class PresentServiceImpl implements PresentService {
    @Autowired
    private PresentRepository presentRepository;

    public List<Present> getAllPresent(){
        return Lists.newArrayList(presentRepository.findAll());
    }

    @Override
    public Present findById(Long id) {
        return presentRepository.findById(id).get();
    }

    @Override
    public List<Present> findByNamePresents(String name) {
        return presentRepository.findByName(name);
    }

    @Override
    public void save(Present present) {
        presentRepository.save(present);
    }

    @Override
    public void delete(Long id) {
        Present present = this.findById(id);
        presentRepository.delete(present);
    }
}
