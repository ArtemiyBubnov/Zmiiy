package com.company;
import javax.swing.*;
import java.awt.*;

public class Graf extends JPanel{
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        // todo: - draw sprites
        g.drawRect(0,0,60,60);
    }
}
