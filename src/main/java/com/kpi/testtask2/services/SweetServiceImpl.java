package com.kpi.testtask2.services;


import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.entities.Sweet;
import com.kpi.testtask2.repository.PresentRepository;
import com.kpi.testtask2.repository.SweetRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetServiceImpl implements SweetService {

    @Autowired
    private SweetRepository sweetRepository;

    public List<Sweet> getAllSweets(){
        return Lists.newArrayList(sweetRepository.findAll());
    }
}
