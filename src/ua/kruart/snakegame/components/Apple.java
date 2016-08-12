package ua.kruart.snakegame.components;

import ua.kruart.snakegame.SnakeGame;

/**Created by kruart on 12.08.2016.*/
public class Apple {

    public int positionX;    //позиция яблока по x
    public int positionY;    //позиция яблока по y

    public Apple(){
        setRandomPosition();
    }

    public void setRandomPosition(){
        positionX = (int)(Math.random() * SnakeGame.WIDTH);
        positionY = (int)(Math.random() * SnakeGame.HEIGHT);
    }
}
