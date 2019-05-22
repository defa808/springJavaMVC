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
}
