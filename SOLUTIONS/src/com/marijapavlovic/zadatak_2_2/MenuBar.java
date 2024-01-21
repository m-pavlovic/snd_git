package com.marijapavlovic.zadatak_2_2;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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

        
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        fstEncoding.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
        sndEncoding.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
        
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
