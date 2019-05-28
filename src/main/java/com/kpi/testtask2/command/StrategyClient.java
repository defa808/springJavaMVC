package com.kpi.testtask2.command;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class StrategyClient {

    private ArrayList<Command> commands = new ArrayList<>();

    public void add(Command command){
        commands.add(command);
    }

    public void runAllCommands(){
        for (Command command:commands) {
            command.execute();
        }
        commands.clear();
    }

    public Integer getCount() {
        return commands.size();
    }
}
