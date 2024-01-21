package com.marijapavlovic.zadatak_2_2;

import java.awt.event.ActionListener;

import javax.swing.*;

public class PopUpMenu extends JPopupMenu {


    private JMenuItem selectAll;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem deleteItem;
    private JMenuItem cutItem;
    private ViewPanel viewPanel;
    private UndoRedoManager undoRedoManager;

    public PopUpMenu(ViewPanel viewPanel) {
        this.viewPanel = viewPanel;
        initComponent();
        layoutComponent();
        activateMenu();

    }

    private void initComponent() {

            selectAll = new JMenuItem("Select all");
            copyItem = new JMenuItem("Copy");
            pasteItem = new JMenuItem("Paste");
            deleteItem = new JMenuItem("Delete");
            cutItem = new JMenuItem("Cut");
            undoRedoManager = new UndoRedoManager();

            selectAll.setVisible(true);
            copyItem.setVisible(true);
            pasteItem.setVisible(true);
            deleteItem.setVisible(true);
            cutItem.setVisible(true);

    }

    private void layoutComponent() {

        add(selectAll);
        add(copyItem);
        add(pasteItem);
        add(deleteItem);
        add(cutItem);

    }

    private void activateMenu() {

        selectAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsInterface selectAll = new SelectAllCommand(viewPanel);
                undoRedoManager.execute(selectAll);
            }
        
        });

        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsInterface copy = new CopyCommand(viewPanel);
                undoRedoManager.execute(copy);
            }
        
        });

        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsInterface paste = new PasteCommand(viewPanel);
                undoRedoManager.execute(paste);
            }
        
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsInterface delete = new DeleteCommand(viewPanel);
                undoRedoManager.execute(delete);
            }
        
        });

        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommandsInterface cut = new CutCommand(viewPanel);
                undoRedoManager.execute(cut);
            }
        
        });

    }

    
}