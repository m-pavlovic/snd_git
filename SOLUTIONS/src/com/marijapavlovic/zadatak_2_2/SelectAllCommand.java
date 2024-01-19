package com.marijapavlovic.zadatak_2_2;

public class SelectAllCommand implements CommandsInterface {

    private ViewPanel viewPanel;

    public SelectAllCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {
        viewPanel.getTextArea().selectAll();

    }

    @Override
    public void unexecute() {
        viewPanel.getTextArea().setSelectionStart(0);

    }
}
