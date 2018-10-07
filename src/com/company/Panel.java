package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private Game game;
    private Timer timerDrawGame, movingTimer;
    private Image background, body, head, emptyField, finishGame;
    private JLabel scoreLabel;
    private JButton restartGameButton, closeGameButton;
    private Panel panel;

    class Key implements KeyListener{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    game.direction =270;
                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    game.direction =90;
                    break;

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    game.direction =0;
                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    game.direction =180;
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    Panel() {

        addKeyListener(new Key());
        setFocusable(true);
        panel = this;

        try {
            this.background = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/background.jpg"));
            this.body = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/body.png"));
            this.head = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/head.png"));
            this.emptyField = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/emptyField.jpg"));
            this.finishGame = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/finishGame.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.game = new Game();
        game.startGame();

        this.timerDrawGame = new Timer(17, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        this.timerDrawGame.start();
        this.setLayout(null);

        movingTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.moveSnakeHead();
                scoreLabel.setText("Score" + game.score);
            }
        });
        movingTimer.start();


        this.scoreLabel = new JLabel("Score: 0");
        this.scoreLabel.setForeground(Color.WHITE);
        this.scoreLabel.setFont(new Font("serif", 0, 30));
        this.scoreLabel.setBounds(630, 200, 150, 50);
        this.add(this.scoreLabel);

        this.restartGameButton = new JButton("New game");
        this.restartGameButton.setForeground(Color.BLUE);
        this.restartGameButton.setFont(new Font("serif", 0, 20));
        this.restartGameButton.setBounds(630, 30, 150, 50);
        this.restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeGameButton.setFocusable(false);
                restartGameButton.setFocusable(false);
                panel.setFocusable(true);
                game.startGame();
            }
        });
        this.add(this.restartGameButton);

        this.closeGameButton = new JButton("Exit");
        this.closeGameButton.setForeground(Color.RED);
        this.closeGameButton.setFont(new Font("serif", 0, 20));
        this.closeGameButton.setBounds(630, 100, 150, 50);
        this.closeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(this.closeGameButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background, 0, 0, 800, 650, null);

        for (int i = 0; i < this.game.field.length; i++)
            for (int j = 0; j < this.game.field[i].length; j++) {
                if (this.game.field[i][j] != 0) {
                    if (this.game.field[i][j] == 1) {
                        g.drawImage(head, 10 + j * 20, 10 + i * 20, 20, 20, null);
                    } else if (this.game.field[i][j] == -1) {
                        g.drawImage(this.emptyField, 10 + j * 20, 10 + i * 20, 20, 20, null);
                    }
                }
            }

        g.setColor(Color.BLUE);
        for (int i = 0; i <= this.game.field.length; i++) {
            g.drawLine(10 + i * 20, 10, 10 + i * 20, 610);
            g.drawLine(10, 10 + i * 20, 610, 10 + i * 20);
        }
    }
}
