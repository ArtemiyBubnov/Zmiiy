package com.company;

import javax.swing.*;

public class Window extends JFrame {
    Window(){

        setVisible(true);
        setBounds(190, 0, 800,650);
        setTitle("SnakeGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().add(new Graf());
    }
}

