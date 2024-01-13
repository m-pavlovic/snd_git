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
        
    }

    
}
