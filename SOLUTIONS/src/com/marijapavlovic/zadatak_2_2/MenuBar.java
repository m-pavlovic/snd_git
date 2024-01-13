package com.marijapavlovic.zadatak_2_2;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu encodingMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem loadMenuItem;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem pasteMenuItem;
    private JMenuItem selectAllMenuItem;
    private JMenuItem fstEncoding;
    private JMenuItem sndEncoding;
    private MenuBarListener menuBarListener;



    public MenuBar() {

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        encodingMenu = new JMenu("Encoding");

        saveMenuItem = new JMenuItem("Save");
        loadMenuItem = new JMenuItem("Load");
        undoMenuItem = new JMenuItem("Undo");
        redoMenuItem = new JMenuItem("Redo");
        cutMenuItem = new JMenuItem("Cut");
        copyMenuItem = new JMenuItem("Copy");
        pasteMenuItem = new JMenuItem("Paste");
        selectAllMenuItem = new JMenuItem("Select All");
        fstEncoding = new JMenuItem("FST-ENCODING");
        sndEncoding = new JMenuItem("SND-ENCODING");

        fileMenu.add(saveMenuItem);
        fileMenu.add(loadMenuItem);
        editMenu.add(undoMenuItem);
        editMenu.add(redoMenuItem);
        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);
        editMenu.add(selectAllMenuItem);
        encodingMenu.add(fstEncoding);
        encodingMenu.add(sndEncoding);

        
        undoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        redoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        pasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        selectAllMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        fstEncoding.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        sndEncoding.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        
        add(fileMenu);
        add(editMenu);
        add(encodingMenu);
        activateComps();
    }


    public void activateComps() {
        saveMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.saveItemClicked(new MenuBarEvent(this));
            }
        });
        loadMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.loadItemClicked(new MenuBarEvent(this));
            }
        });
        undoMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.undoItemClicked(new MenuBarEvent(this));
            }
        });
        redoMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.redoItemClicked(new MenuBarEvent(this));
            }
        });
        cutMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.cutItemClicked(new MenuBarEvent(this));
            }
        });
        copyMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.copyItemClicked(new MenuBarEvent(this));
            }
        });
        pasteMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.pasteItemClicked(new MenuBarEvent(this));
            }
        });
        selectAllMenuItem.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.selectAllItemClicked(new MenuBarEvent(this));
            }
        });
        fstEncoding.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.fstEncodingItemClicked(new MenuBarEvent(this));
            }
        });
        sndEncoding.addActionListener(e -> {
            if (menuBarListener != null) {
                menuBarListener.sndEncodingItemClicked(new MenuBarEvent(this));
            }
        });
    }



    public void setMenuBarListener(MenuBarListener menuBarListener) {
        this.menuBarListener = menuBarListener;
        }
    
}
