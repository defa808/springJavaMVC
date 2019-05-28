package com.kpi.testtask2.command;

import com.kpi.testtask2.services.ServiceBase;

public class InsertCommand<T> implements Command {
    private ServiceBase<T> service;

    private T item;

    public InsertCommand(ServiceBase service, T item) {
        this.service = service;
        this.item = item;
    }

    @Override
    public void execute() {
        service.save(item);
    }
}
