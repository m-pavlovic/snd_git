package com.marijapavlovic.zadatak_2_3;

import java.util.EventListener;

public interface MenuBarListener extends EventListener {
        
    public void loadItemClicked(MenuBarEvent event);
    public void saveItemClicked(MenuBarEvent event);
    public void copyItemClicked(MenuBarEvent event);
    public void pasteItemClicked(MenuBarEvent event);
    public void cutItemClicked(MenuBarEvent event);
    public void selectAllItemClicked(MenuBarEvent event);
    public void undoItemClicked(MenuBarEvent event);
    public void redoItemClicked(MenuBarEvent event);
    public void fstEncodingItemClicked(MenuBarEvent event);
    public void sndEncodingItemClicked(MenuBarEvent event);
}
