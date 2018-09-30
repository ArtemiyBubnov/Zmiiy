package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import java.io.*;

public class Graf extends JPanel{

    private static final int GRID_SIZE =20;
    private static final int MARGIN_LEFT =10;
    private static final int MARGIN_RIGHT =610;

    private GameField game;
    private Timer timerDrawGame;
    private Image background, body, head, fruit, finishGame, tail;
    private JLabel scoreLabel;
    private JButton restartGame, closeGame;

    Graf(){
//        try{
//            background = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/background.png"));
//            finishGame = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/finishGame.jpg"));
//            tail = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/tail.png"));
//            fruit = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/fruit.png"));
//            head = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/head.png"));
//            body = ImageIO.read(new File("C:/Users/student12/Documents/4module/Zmiiy/res/body.png"));
//        }catch (IOException e){ e.printStackTrace();}

        game = new GameField();
        game.startGame();
        timerDrawGame = new Timer(17, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timerDrawGame.start();
        setLayout(null);

        scoreLabel = new JLabel("Score: ");
        scoreLabel.setForeground(Color.ORANGE);
        scoreLabel.setFont(new Font("serif",0,32));
        scoreLabel.setBounds(630,200, 150, 50);
        add(scoreLabel);

        restartGame = new JButton("Restart");
        restartGame.setForeground(Color.BLUE);
        restartGame.setFont(new Font("serif",2,32));
        restartGame.setBounds(630,30, 150, 50);
        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.startGame();
            }
        });
        add(restartGame);

       closeGame = new JButton("Exit");
      closeGame.setForeground(Color.red);
      closeGame.setFont(new Font("serif",2,32));
      closeGame.setBounds(630,100, 150, 50);
       closeGame.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
               System.exit(0);
          }
       });
      add(closeGame);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i=0; i<game.field.length; i++){
            for(int j=0; j<game.field.length; j++){
                if (game.field[i][j] !=0){
                    if(game.field[i][j] ==1){
                        g.drawImage(head, MARGIN_LEFT + j*GRID_SIZE, MARGIN_LEFT + i*GRID_SIZE, GRID_SIZE, GRID_SIZE, null);
                    }else if (game.field[i][j] ==-1){
                        g.drawImage(fruit, MARGIN_LEFT + j*GRID_SIZE, MARGIN_LEFT + i*GRID_SIZE, GRID_SIZE, GRID_SIZE, null);
                    }
                }
            }
        }

        g.setColor(Color.blue);
        for (int i=0; i<=this.game.field.length; i++){
        g.drawLine(10+i*GRID_SIZE, 10, 10 + i*GRID_SIZE, MARGIN_RIGHT);
         g.drawLine(10, 10+i*GRID_SIZE,MARGIN_RIGHT, 10+ i*GRID_SIZE);
        }
    }
}
