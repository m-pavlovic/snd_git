package com.marijapavlovic.zadatak_2_2;

import java.awt.event.ActionListener;
import java.util.EventObject;


public class MenuBarEvent extends EventObject {

    private boolean loadItemClicked;
    private boolean saveItemClicked;
    private boolean copyItemClicked;
    private boolean pasteItemClicked;
    private boolean cutItemClicked;
    private boolean selectAllItemClicked;
    private boolean undoItemClicked;
    private boolean redoItemClicked;
    private boolean fstEncodingItemClicked;
    private boolean sndEncodingItemClicked;

    public MenuBarEvent(Object source) {
        super(source);
        this.loadItemClicked = false;
        this.saveItemClicked = false;
        this.copyItemClicked = false;
        this.pasteItemClicked = false;
        this.cutItemClicked = false;
        this.selectAllItemClicked = false;
        this.undoItemClicked = false;
        this.redoItemClicked = false;
        this.fstEncodingItemClicked = false;
        this.sndEncodingItemClicked = false;
    }
}