package com.marijapavlovic.zadatak_2_2;

import java.util.EventListener;

public interface ViewPanelListener extends EventListener {


    public void textChanged(ViewPanelEvent event);
    public void textSelected(ViewPanelEvent event);
    public void textCopied(ViewPanelEvent event);
    public void textPasted(ViewPanelEvent event);
    public void textCut(ViewPanelEvent event);
    public void textUndo(ViewPanelEvent event);
    public void textRedo(ViewPanelEvent event);
    public void textFstEncoding(ViewPanelEvent event);
    public void textSndEncoding(ViewPanelEvent event);
    public void textSelectAll(ViewPanelEvent event);
    public void textDeleted(ViewPanelEvent event);
    
}
