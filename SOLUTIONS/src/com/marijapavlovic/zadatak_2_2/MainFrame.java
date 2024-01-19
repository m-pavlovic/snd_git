package com.marijapavlovic.zadatak_2_2;

import javax.swing.*;

public class MainFrame extends JFrame {


    private MenuBar menuBar;
    private ViewPanel viewPanel;


    public MainFrame() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        layoutComponents();
        actionComponents();
        setVisible(true);
        
    }

    private void initComponents() {
        menuBar = new MenuBar();
        viewPanel = new ViewPanel();
        


    }

    private void layoutComponents() {
        setJMenuBar(menuBar);
        add(viewPanel);

    }


    private void actionComponents() {
        menuBar.setMenuBarListener(new MenuBarListener() {
            @Override
            public void loadItemClicked(MenuBarEvent event) {
                JOptionPane.showMessageDialog(MainFrame.this, "Load item clicked");
                //open joption pane with file chooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(MainFrame.this);
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                if (path.endsWith(".txt")) {
                    ReadWriteStrategy readWriteStrategy = new ReadWriteTxt();
                    StringBuffer sb = readWriteStrategy.loadFromFile(path);
                    viewPanel.setTextArea(sb.toString());
                } else if (path.endsWith(".bin")) {
                    ReadWriteStrategy readWriteStrategy = new ReadWriteBin();
                    StringBuffer sb = readWriteStrategy.loadFromFile(path);
                    viewPanel.setTextArea(sb.toString());
                } else {
                    System.out.println("Unknown");
                }
            }

            @Override
            public void saveItemClicked(MenuBarEvent event) {
                JOptionPane.showMessageDialog(MainFrame.this, "Save item clicked");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(MainFrame.this);
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                if (path.endsWith(".txt")) {
                    ReadWriteStrategy readWriteStrategy = new ReadWriteTxt();
                    readWriteStrategy.saveToFile(path, viewPanel.getTextArea());
                } else if (path.endsWith(".bin")) {
                    ReadWriteStrategy readWriteStrategy = new ReadWriteBin();
                    readWriteStrategy.saveToFile(path, viewPanel.getTextArea());
                } else {
                    System.out.println("Unknown");
                }
            }

            @Override
            public void copyItemClicked(MenuBarEvent event) {
            }

            @Override
            public void pasteItemClicked(MenuBarEvent event) {
                System.out.println("Paste item clicked");
            }

            @Override
            public void cutItemClicked(MenuBarEvent event) {
                System.out.println("Cut item clicked");
            }

            @Override
            public void selectAllItemClicked(MenuBarEvent event) {
                System.out.println("Select all item clicked");
            }

            @Override
            public void undoItemClicked(MenuBarEvent event) {
                System.out.println("Undo item clicked");
            }

            @Override
            public void redoItemClicked(MenuBarEvent event) {
                System.out.println("Redo item clicked");
            }

            @Override
            public void fstEncodingItemClicked(MenuBarEvent event) {
                System.out.println("First encoding item clicked");
            }

            @Override
            public void sndEncodingItemClicked(MenuBarEvent event) {
                System.out.println("Second encoding item clicked");
            }
        });

        viewPanel.setViewPanelListener(new ViewPanelListener() {
            @Override
            public void textChanged(ViewPanelEvent event) {
                System.out.println("Text changed");
            }

            @Override
            public void textSelected(ViewPanelEvent event) {
                System.out.println("Text selected");
            }

            @Override
            public void textCopied(ViewPanelEvent event) {
                System.out.println("Text copied");
            }

            @Override
            public void textPasted(ViewPanelEvent event) {
                System.out.println("Text pasted");
            }

            @Override
            public void textCut(ViewPanelEvent event) {
                System.out.println("Text cut");
            }

            @Override
            public void textUndo(ViewPanelEvent event) {
                System.out.println("Text undo");
            }

            @Override
            public void textRedo(ViewPanelEvent event) {
                System.out.println("Text redo");
            }

            @Override
            public void textFstEncoding(ViewPanelEvent event) {
                System.out.println("Text first encoding");
            }

            @Override
            public void textSndEncoding(ViewPanelEvent event) {
                System.out.println("Text second encoding");
            }

            @Override
            public void textSelectAll(ViewPanelEvent event) {
                System.out.println("Text select all");
            }

            @Override
            public void textDeleted(ViewPanelEvent event) {
                System.out.println("Text deleted");
            }
            
        });

        viewPanel.actionComponents();
    }

    
}
