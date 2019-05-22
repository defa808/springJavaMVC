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
    public String addPresent(@RequestParam String name, Model model){
        Present present = new Present(name);
        presentService.save(present);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPresent(@RequestParam Long id, Model model){
        Present present = presentService.findById(id);
        model.addAttribute("present", present);
        return "presentEdit";
    }

    @PostMapping("/edit")
    public String editPresent(@RequestParam Long id,String name, Model model){
        Present present = presentService.findById(id);
        present.setName(name);
        presentService.save(present);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deletePresent(@RequestParam Long id, Model model){
        presentService.delete(id);
        return "redirect:/";
    }
}
