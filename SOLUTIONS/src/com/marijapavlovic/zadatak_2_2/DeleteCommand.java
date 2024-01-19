package com.marijapavlovic.zadatak_2_2;

public class DeleteCommand implements CommandsInterface {

    private ViewPanel viewPanel;
    private String temp;

    public DeleteCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }


    @Override
    public void execute() {
        temp = viewPanel.getTextArea().getSelectedText();
        if (temp != null) {
            viewPanel.getTextArea().replaceSelection("");
        }


    }

    @Override
    public void unexecute() {
        if (temp != null) {
            viewPanel.getTextArea().replaceSelection(temp);
        }


    }
}
