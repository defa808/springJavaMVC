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
    private final SweetService sweetPresentService;

    public HomeController(PresentService presentService, SweetService sweetPresentService) {
        this.presentService = presentService;
        this.sweetPresentService = sweetPresentService;

    }

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Sweet> sweets = sweetPresentService.getAllSweets();
        List<Present> presents = presentService.getAllPresent();
        if(filter != null && !filter.isEmpty()){
            presents = presentService.findByNamePresents(filter);
        }

        StringBuilder sum = new StringBuilder();

        for (Present present: presents) {
            sum.append(" here - > ").append(present.getSweets().size());
        }
        model.addAttribute("length", sum);
        model.addAttribute("presents", presents);
        model.addAttribute("sweetsController", sweets);
        model.addAttribute("filter", filter);
        return "test";
    }

    @GetMapping("/hop")
    public String getSome(Model model) {

        return "index";
    }



}
