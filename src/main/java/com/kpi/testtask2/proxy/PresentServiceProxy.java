package com.kpi.testtask2.proxy;

import com.kpi.testtask2.entities.Present;
import com.kpi.testtask2.services.PresentService;
import com.kpi.testtask2.services.PresentServiceImpl;
import com.kpi.testtask2.services.ServiceBase;

public class PresentServiceProxy implements ServiceBase<Present> {
    private PresentService presentService = new PresentServiceImpl();


    @Override
    public Present findById(Long id) {
        System.out.println("Finding Present by Id");
        return presentService.findById(id);
    }

    @Override
    public void save(Present present) {
        System.out.println("Present save");
        System.out.println("Look ->");
        System.out.println(present);
        presentService.save(present);
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete present by Id -> ");
        System.out.println(id);
        presentService.delete(id);
    }
}
