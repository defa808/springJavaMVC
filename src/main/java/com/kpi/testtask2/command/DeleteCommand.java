package com.kpi.testtask2.command;

import com.kpi.testtask2.services.ServiceBase;

public class DeleteCommand<T> implements Command {

    private ServiceBase<T> service;

    private Long id;

    public DeleteCommand(ServiceBase<T> service, Long id) {
        this.service = service;
        this.id = id;
    }

    @Override
    public void execute() {
        this.service.delete(this.id);
    }
}
