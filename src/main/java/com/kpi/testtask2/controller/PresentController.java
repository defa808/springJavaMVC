package com.kpi.testtask2.controller;

import com.kpi.testtask2.command.DeleteCommand;
import com.kpi.testtask2.command.InsertCommand;
import com.kpi.testtask2.command.StrategyClient;
import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.services.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("/present")
public class PresentController {
    private final PresentService presentService;

    @Autowired
    private StrategyClient strategyClient;

    public PresentController(PresentService presentService, StrategyClient strategyClient) {
        this.presentService = presentService;
        this.strategyClient = strategyClient;
    }

    @PostMapping("/add")
    public String addPresent(@RequestParam String name, Model model) {
        strategyClient.add(new InsertCommand<Present>(presentService, new Present(name)));
//        Present present = new Present(name);
//        presentService.save(present);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editPresent(@RequestParam Long id, Model model) {
        Present present = presentService.findById(id);
        model.addAttribute("present", present);
        return "presentEdit";
    }

    @PostMapping("/edit")
    public String editPresent(@RequestParam Long id, String name, Model model) {
        Present present = presentService.findById(id);
        present.setName(name);
        presentService.save(present);
        return "redirect:/";
    }

    @GetMapping("run")
    public String runCommands(){
        strategyClient.runAllCommands();
        return "redirect:/";
    }

    @GetMapping("count")
    @ResponseBody
    public String getCount(){
        return strategyClient.getCount().toString();
    }

    @GetMapping("/delete")
    public String deletePresent(@RequestParam Long id, Model model) {
        strategyClient.add(new DeleteCommand<Present>(presentService, id));
//        presentService.delete(id);
        return "redirect:/";
    }
}
