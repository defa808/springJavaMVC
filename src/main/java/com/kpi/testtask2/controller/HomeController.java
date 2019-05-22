package com.kpi.testtask2.controller;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.services.PresentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class HomeController {

    private final PresentService presentService;

    public HomeController(PresentService presentService) {
        this.presentService = presentService;
    }

    @GetMapping("/hop")
    public String getSome(Model model) {
        List<Present> presents = presentService.getAllPresent();
        model.addAttribute("presents", presents);
        return "index";
    }
}
