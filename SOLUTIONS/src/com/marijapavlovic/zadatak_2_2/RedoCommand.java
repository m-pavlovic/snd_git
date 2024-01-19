package com.marijapavlovic.zadatak_2_2;


public class RedoCommand implements CommandsInterface {

    private ViewPanel viewPanel;

    public RedoCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {
        
    }

    @Override
    public void unexecute() {

    }
}
