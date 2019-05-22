package com.kpi.testtask2.controller;

import com.kpi.testtask2.services.PresentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
public class PresentController {
    private final PresentService presentService;

    public PresentController(PresentService presentService) {
        this.presentService = presentService;
    }
}
