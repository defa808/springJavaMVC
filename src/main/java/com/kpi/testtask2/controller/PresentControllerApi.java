package com.kpi.testtask2.controller;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.services.PresentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("present")
public class PresentControllerApi {

    private final PresentService presentService;

    public PresentControllerApi(PresentService presentService) {
        this.presentService = presentService;
    }

    @GetMapping
    public List<Present> list(){
        return presentService.getAllPresent();
    }

    @GetMapping("{name}")
    public List<Present> getListByName(@PathVariable String name) {
        return presentService.findByNamePresents(name);
    }

    @PostMapping
    public void create(@RequestBody Present present){
        presentService.save(present);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Present present){
        Present currentPresent = presentService.findById(id);
        currentPresent.setName(present.getName());
        presentService.save(currentPresent);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        presentService.delete(id);
    }

}
