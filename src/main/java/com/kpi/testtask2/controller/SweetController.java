package com.kpi.testtask2.controller;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.entities.Sweet;
import com.kpi.testtask2.repository.SweetRepository;
import com.kpi.testtask2.services.PresentService;
import com.kpi.testtask2.services.SweetService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@EnableAutoConfiguration
@RequestMapping("/sweet")
public class SweetController {
    private final SweetService sweetService;
    private final PresentService presentService;

    public SweetController(SweetService sweetService, PresentService presentService) {
        this.sweetService = sweetService;
        this.presentService = presentService;
    }

    @PostMapping("/add")
    public String add(@RequestParam String name, String developerName, String shelfLife, Long presentId, Model model) {
        java.sql.Date sqlStartDate = parseDate(shelfLife);
        Sweet sweet = new Sweet(name, developerName, sqlStartDate);
        Present present = presentService.findById(presentId);
        sweet.setPresent(present);
        sweetService.save(sweet);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        Sweet sweet = sweetService.findById(id);
        model.addAttribute("sweet", sweet);
        return "sweetEdit";
    }

    @PostMapping("/edit")
    public String editPresent(@RequestParam Long id, String name, String developerName, String shelfLife, Model model) {
        Sweet sweet = sweetService.findById(id);
        java.sql.Date sqlStartDate = parseDate(shelfLife);
        sweet.setDeveloperName(developerName);
        sweet.setShelfLife(sqlStartDate);
        sweet.setName(name);
        sweetService.save(sweet);
        return "redirect:/";
    }

    private Date parseDate(String str) {
        java.sql.Date sqlStartDate;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date date = sdf1.parse(str);
            sqlStartDate = new java.sql.Date(date.getTime());
        } catch (java.text.ParseException e) {
            sqlStartDate = new Date(0);
        }
        return sqlStartDate;
    }

    @GetMapping("/delete")
    public String deletePresent(@RequestParam Long id, Model model) {
        sweetService.delete(id);
        return "redirect:/";
    }

}
