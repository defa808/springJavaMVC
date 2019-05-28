package com.kpi.testtask2.controller;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.entities.Sweet;
import com.kpi.testtask2.services.PresentService;
import com.kpi.testtask2.services.SweetService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class HomeController {

    private final PresentService presentService;

    public HomeController(PresentService presentService) {
        this.presentService = presentService;

    }

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Present> presents = presentService.getAllPresent();
        if(filter != null && !filter.isEmpty()){
            presents = presentService.findByNamePresents(filter);
        }

        model.addAttribute("presents", presents);
        model.addAttribute("filter", filter);
        return "index";
    }

}
