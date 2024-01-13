package com.marijapavlovic.zadatak_2_2;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class ViewPanel extends JPanel {
    

    private JScrollPane scrollPane;
    private JTextArea textArea;


    public ViewPanel() {
        scrollPane = new JScrollPane();
        textArea = new JTextArea(20, 35);
        scrollPane.setViewportView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBackground(Color.BLACK);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 22));
        add(scrollPane);
    }
}
