package com.kpi.testtask2.controller;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.services.PresentService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration
@RequestMapping("/present")
public class PresentController {
    private final PresentService presentService;

    public PresentController(PresentService presentService) {
        this.presentService = presentService;
    }

    @PostMapping("/add")
    public String editArtist(@RequestParam String name, Model model){
        Present present = new Present(name);
        presentService.savePresent(present);
        return "redirect:/";
    }
}
