package ua.kruart.snakegame;

import javax.swing.*;
import java.awt.*;

/**Created by kruart on 11.08.2016.*/
public class SnakeGame extends JPanel{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public SnakeGame(){
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//создаем frame
        frame.setResizable(false);//нельзя изменять размер окна
        frame.setSize(WIDTH * SCALE  + 7, HEIGHT * SCALE + 30); //задаем размер frame
        frame.setLocationRelativeTo(null);//null - означает, что окно будет размещено по центру экрана
        frame.add(new SnakeGame());
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(color(5, 50, 10));   //устанавливаем цвет для фона
        g.fillRect(2, 2, WIDTH * SCALE, HEIGHT * SCALE); //заливаем фон
        g.setColor(color(175, 176, 125));//устанавливаем цвет для сетки

        for (int i = 0; i <= WIDTH * SCALE; i+=SCALE) {
            g.drawLine(i, 0, i, HEIGHT * SCALE);    //заливаем сетку по вертикали
        }

        for (int i = 0; i <= HEIGHT * SCALE; i+=SCALE) {
            g.drawLine(0, i, WIDTH * SCALE, i);    //заливаем сетку по горизонтали
        }
    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }
}
