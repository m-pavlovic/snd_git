package com.marijapavlovic.zadatak_2_2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class MainFrame extends JFrame {


    private MenuBar menuBar;
    private ViewPanel viewPanel;
    private JFileChooser fileChooser;
    private static final String DIR = "DATA";


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
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("DATA"));
        FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
                "TXT files", "txt");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
                "BIN files", "bin");
        fileChooser.setFileFilter(filter1);
        fileChooser.addChoosableFileFilter(filter2);
        alignSaveWithExtensions();
        


    }

    private void alignSaveWithExtensions(){
        fileChooser.addActionListener(ae -> {
            if (ae.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)){
                String path = fileChooser.getSelectedFile().getPath();
                if (fileChooser.getFileFilter().getDescription().equals("TXT files")){
                    if (!path.endsWith(".txt")){
                        path += ".txt";
                    }
                } else if (fileChooser.getFileFilter().getDescription().equals("BIN files")){
                    if (!path.endsWith(".bin")){
                        path += ".bin";
                    }
                }
                fileChooser.setSelectedFile(new File(path));
            }
        });

    }

    private void layoutComponents() {
        setJMenuBar(menuBar);
        add(viewPanel);

    }


    private void actionComponents() {
        menuBar.setMenuBarListener(new MenuBarListener() {
            @Override
            public void loadItemClicked(MenuBarEvent event) {
                int value = fileChooser.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    if (path.endsWith(".txt")) {
                        String text = new ReadWriteTxt().loadFromFile(path).toString();
                        viewPanel.setTextArea(text);
                    } else if (path.endsWith(".bin")) {
                        String text = new ReadWriteBin().loadFromFile(path).toString();
                        viewPanel.setTextArea(text);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please choose a file extension!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void saveItemClicked(MenuBarEvent event) {
                if (!new File(DIR).exists()){
                    new File(DIR).mkdir();
                }
                int value = fileChooser.showSaveDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    if (path.endsWith(".txt")) {
                        new ReadWriteTxt().saveToFile(path, viewPanel.getTextArea());
                    } else if (path.endsWith(".bin")) {
                        new ReadWriteBin().saveToFile(path, viewPanel.getTextArea());
                    } else {
                        JOptionPane.showMessageDialog(null, "Please choose a file extension!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            @Override
            public void copyItemClicked(MenuBarEvent event) {
                CommandsInterface copyCommand = new CopyCommand(viewPanel);
                copyCommand.execute();
            }

            @Override
            public void pasteItemClicked(MenuBarEvent event) {
                CommandsInterface pasteCommand = new PasteCommand(viewPanel);
                pasteCommand.execute();
            }

            @Override
            public void cutItemClicked(MenuBarEvent event) {
                CommandsInterface cutCommand = new CutCommand(viewPanel);
                cutCommand.execute();
            }

            @Override
            public void selectAllItemClicked(MenuBarEvent event) {
                CommandsInterface selectAllCommand = new SelectAllCommand(viewPanel);
                selectAllCommand.execute();
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
            }

            @Override
            public void textCopied(ViewPanelEvent event) {
            }

            @Override
            public void textPasted(ViewPanelEvent event) {
            }

            @Override
            public void textCut(ViewPanelEvent event) {
            }

            @Override
            public void textUndo(ViewPanelEvent event) {
            }

            @Override
            public void textRedo(ViewPanelEvent event) {
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
            }

            @Override
            public void textDeleted(ViewPanelEvent event) {
            }

        });

        viewPanel.actionComponents();
    }

    
}
