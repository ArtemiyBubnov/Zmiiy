package com.company;

public class GameField {
    int[][] field;

    GameField(){
        field = new int[30][30];
    }

    void startGame(){
        for(int i = 0; i < field.length; i++)
            for(int j = 0;j < field[i].length; j++)
                field[i][j]=0;
            field[15][15]=1;
            generateFood();
    }
    void generateFood(){
        int x;
        int y;
        do{
            x = (int)(Math.random()*field.length);
            y = (int)(Math.random()*field[x].length);
            if (field[x][y] == 0){
                field[x][y] = -1;
            break;
            }
        }while (field[x][y] != 0);
    }
}
