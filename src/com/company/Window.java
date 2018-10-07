package com.company;

import javax.swing.*;

public class Window extends JFrame {

    Window() {
        Panel panel = new Panel();
        this.getContentPane().add(panel);

        this.setTitle("Snake");
        this.setBounds(0, 0, 800, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

}
