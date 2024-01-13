package com.marijapavlovic.zadatak_2_2;

import java.util.EventObject;

public class ViewPanelEvent extends EventObject {


    private boolean textChanged;
    private boolean textSelected;
    private boolean textCopied;
    private boolean textPasted;
    private boolean textCut;
    private boolean textUndo;
    private boolean textRedo;
    private boolean textFstEncoding;
    private boolean textSndEncoding;
    private boolean textSelectAll;
    private boolean textDeleted;



    public ViewPanelEvent(Object source) {
        super(source);
        this.textChanged = false;
        this.textSelected = false;
        this.textCopied = false;
        this.textPasted = false;
        this.textCut = false;
        this.textUndo = false;
        this.textRedo = false;
        this.textFstEncoding = false;
        this.textSndEncoding = false;
        this.textSelectAll = false;
        this.textDeleted = false;
    }
    
}
