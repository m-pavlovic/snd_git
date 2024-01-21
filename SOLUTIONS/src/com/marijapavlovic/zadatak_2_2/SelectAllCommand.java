package com.marijapavlovic.zadatak_2_2;

public class SelectAllCommand implements CommandsInterface {
    
    private ViewPanel viewPanel;
    private int previousSelectionStart;
    private int previousSelectionEnd;

    public SelectAllCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public void execute() {
        previousSelectionStart = viewPanel.getTextArea().getSelectionStart();
        previousSelectionEnd = viewPanel.getTextArea().getSelectionEnd();
        viewPanel.getTextArea().selectAll();
    }

    @Override
    public void unexecute() {
        viewPanel.getTextArea().setSelectionStart(previousSelectionStart);
        viewPanel.getTextArea().setSelectionEnd(previousSelectionEnd);
    }
}
