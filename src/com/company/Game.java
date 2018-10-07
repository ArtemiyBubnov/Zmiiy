package com.company;

public class Game {

    public int[][] field;
    public int direction;
    private int headX, headY;
    public int score;
    public boolean isFinish;

    Game() {
        this.field = new int[30][30];
    }

    public void startGame() {
        for (int i = 0; i < this.field.length; i++)
            for (int j = 0; j < this.field[i].length; j++)
                this.field[i][j] = 0;

        this.direction = 0;
        this.score = 0;
        this.headX = this.headY = 15;
        field[15][15] = 1;
        this.generateFood();
        isFinish = false;
    }

    private void generateFood() {
        while (true) {
            int x = (int)(Math.random() * 30);
            int y = (int)(Math.random() * 30);

            if (this.field[y][x] == 0) {
                this.field[y][x] = -1;
                break;
            }
        }
    }

    public void moveSnakeHead() {
        this.field[headY][headX] = 0;

        switch (this.direction) {
            case 0:
                if (this.headX - 1 >= 0) {
                    this.headX--;
                } else {
                    this.headX = 29;
                }
                break;
            case 90:
                if (this.headY - 1 >= 0) {
                    this.headY--;
                } else {
                    this.headY = 29;
                }
                break;
            case 180:
                if (this.headX + 1 <= 29) {
                    this.headX++;
                } else {
                    this.headX = 0;
                }
                break;
            case 270:
                if (this.headY + 1 <= 29) {
                    this.headY++;
                } else {
                    this.headY = 0;
                }
                break;
        }

        if (this.field[headY][headX] == -1) {
            this.generateFood();
            this.score += 10;

        }

        this.field[headY][headX] = 1;
    }

}
