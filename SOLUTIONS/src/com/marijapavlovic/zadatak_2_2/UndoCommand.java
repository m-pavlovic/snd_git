package com.marijapavlovic.zadatak_2_2;

public class UndoCommand implements CommandsInterface {

    private ViewPanel viewPanel;

    public UndoCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {

        

    }

    @Override
    public void unexecute() {

    }
}
