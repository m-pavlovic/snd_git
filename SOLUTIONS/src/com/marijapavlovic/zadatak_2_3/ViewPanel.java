package com.marijapavlovic.zadatak_2_3;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewPanel extends JPanel implements TextAreaInterface {


    private JScrollPane scrollPane;
    private JTextArea textArea;
    private PopUpMenu popUpMenu;
    private UndoRedoManager undoRedoManager;


    public ViewPanel() {
        initComponents();
        layoutComponents();
    }

    public void initComponents() {
        popUpMenu = new PopUpMenu(this);
        scrollPane = new JScrollPane();
        textArea = new JTextArea(20, 58);
    }

    public void layoutComponents() {
        scrollPane.setViewportView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
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

    @Override
    public void setTextArea(String text) {
        textArea.setText(text);
    }

    @Override
    public JTextArea getTextArea() {
        return textArea;
    }


    public void deselectAllText() {
        textArea.select(0, 0);
    }

    public void getSelectedText() {
        textArea.getSelectedText();
    }

    public void setPopUpMenu(PopUpMenu popUpMenu) {
        this.popUpMenu = popUpMenu;
    }

    public void setUndoRedoManager(UndoRedoManager undoRedoManager) {
        this.popUpMenu.setUndoRedoManager(undoRedoManager);
    }
}