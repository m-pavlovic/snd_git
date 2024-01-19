package com.marijapavlovic.zadatak_2_2;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewPanel extends JPanel {
    

    private static final String ViewPanelListener = null;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    private JPopupMenu popupMenu;
    private JMenuItem copyItem;
    private JMenuItem pasteItem;
    private JMenuItem cutItem;
    private JMenuItem selectAllItem;
    private JMenuItem deleteItem;
    private ViewPanelListener listener;


    public ViewPanel() {
        initComponents();
        layoutComponents();
        actionComponents();
    }

    public void initComponents() {
        popupMenu = new JPopupMenu();
        copyItem = new JMenuItem("Copy");
        pasteItem = new JMenuItem("Paste");
        cutItem = new JMenuItem("Cut");
        selectAllItem = new JMenuItem("Select All");
        deleteItem = new JMenuItem("Delete");
        scrollPane = new JScrollPane();
        textArea = new JTextArea(20, 35);
    }

    public void layoutComponents() {
        popupMenu.setBackground(Color.WHITE);
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);
        popupMenu.add(cutItem);
        popupMenu.add(selectAllItem);
        popupMenu.add(deleteItem);
        
        scrollPane.setViewportView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 22));
        add(scrollPane);
    }

    public void setViewPanelListener(ViewPanelListener listener) {
        this.listener = listener;
    }

    public void actionComponents() {
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        copyItem.addActionListener(e -> {
            if (listener != null) {
                listener.textCopied(new ViewPanelEvent(this));
            }
        });

        pasteItem.addActionListener(e -> {
            if (listener != null) {
                listener.textPasted(new ViewPanelEvent(this));
            }
        });

        cutItem.addActionListener(e -> {
            if (listener != null) {
                listener.textCut(new ViewPanelEvent(this));
            }
        });

        selectAllItem.addActionListener(e -> {
            if (listener != null) {
                listener.textSelectAll(new ViewPanelEvent(this));
            }
        });

        deleteItem.addActionListener(e -> {
            if (listener != null) {
                listener.textDeleted(new ViewPanelEvent(this));
            }
        });

    }

    public void setTextArea(String string) {
        textArea.setText(string);
    }

    public String getTextArea() {
        return textArea.getText();
    }
}
