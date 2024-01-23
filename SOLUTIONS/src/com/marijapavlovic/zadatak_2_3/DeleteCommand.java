package com.marijapavlovic.zadatak_2_3;

public class DeleteCommand implements CommandsInterface {
    
    private ViewPanel viewPanel;
    private String deletedText;
    private int deletePosition;

    public DeleteCommand(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
    }

    @Override
    public void execute() {
        deletePosition = viewPanel.getTextArea().getSelectionStart();
        deletedText = viewPanel.getTextArea().getSelectedText();
        if (deletedText != null) {
            viewPanel.getTextArea().replaceSelection("");
        }
    }

    @Override
    public void unexecute() {
        if (deletedText != null) {
            viewPanel.getTextArea().insert(deletedText, deletePosition);
        }
    }
}
