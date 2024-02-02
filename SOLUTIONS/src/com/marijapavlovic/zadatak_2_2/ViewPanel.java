package com.marijapavlovic.zadatak_2_2;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewPanel extends JPanel {


    private JScrollPane scrollPane;
    private JTextArea textArea;
    private PopUpMenu popUpMenu;


    public ViewPanel() {
        initComponents();
        layoutComponents();
    }

    public void initComponents() {
        popUpMenu = new PopUpMenu(this);
        scrollPane = new JScrollPane();
        textArea = new JTextArea(20, 35);
    }

    public void layoutComponents() {
        scrollPane.setViewportView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.requestFocusInWindow();
        textArea.setFont(new Font("Courier New", Font.PLAIN, 22));
        add(scrollPane);
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popUpMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

        });

    }


    public void setTextArea(String text) {
        textArea.setText(text);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void deselectAllText() {
        textArea.select(0, 0);
    }


    public String getSelectedText() {
        return textArea.getSelectedText();
    }

    public void setPopUpMenu(PopUpMenu popUpMenu) {
        this.popUpMenu = popUpMenu;
    }

    public void setUndoRedoManager(UndoRedoManager undoRedoManager) {
        this.popUpMenu.setUndoRedoManager(undoRedoManager);
    }

}