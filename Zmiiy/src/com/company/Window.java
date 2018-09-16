package com.company;

import javax.swing.*;

public class Window extends JFrame {
    Window(){

        setVisible(true);
        setBounds(190, 80, 800,600);
        setTitle("SnakeGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().add(new Graf());
    }
}

