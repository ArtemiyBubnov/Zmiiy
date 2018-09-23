package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graf extends JPanel{

    private static final int GRID_SIZE =20;
    private GameField game;
    private Timer timerDrawGame;
    private Image background, body, head, emptyField, finishGame;
    private JLabel scoreLabel;
    private JButton restartGame, closeGame;

    Graf(){
        game = new GameField();
        game.startGame();
        timerDrawGame = new Timer(17,
        new ActionListener(){
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
        g.setColor(Color.blue);
        for (int i=0; i<=this.game.field.length; i++){
        g.drawLine(10+i*GRID_SIZE, 10, 10 + i*GRID_SIZE, 610);
         g.drawLine(10, 10+i*GRID_SIZE,610, 10+ i*GRID_SIZE);
        }
    }
}
