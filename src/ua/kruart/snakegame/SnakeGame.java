package ua.kruart.snakegame;

import ua.kruart.snakegame.components.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Created by kruart on 11.08.2016.*/
public class SnakeGame extends JPanel implements ActionListener{

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Snake s = new Snake(10, 10, 9, 10); //создаем объект змейки с начально заданными координатами
    Timer t = new Timer(1000 / SPEED, this); //таймер. 1000 / SPEED = кол-во передвижений в секунду

    public SnakeGame(){
        t.start();      //запуск таймера
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();//создаем frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//автомотическое закрытие фрейма, при остановки приложения
        frame.setResizable(false);//нельзя изменять размер окна
        frame.setSize(WIDTH * SCALE  + 7, HEIGHT * SCALE + 30); //задаем размер frame
        frame.setLocationRelativeTo(null);//null - означает, что окно будет размещено по центру экрана
        frame.add(new SnakeGame());     //добавляем JPanel в фрейм. Т.к. SnakeGame extends JPanel
        frame.setVisible(true);     //отображаем окно фрейма
    }

    public void paint(Graphics g) {
        g.setColor(color(5, 50, 10));   //устанавливаем цвет для фона
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE); //заливаем фон
        g.setColor(color(175, 176, 125));//устанавливаем цвет для сетки

        for (int i = 0; i <= WIDTH * SCALE; i+=SCALE) {
            g.drawLine(i, 0, i, HEIGHT * SCALE);    //заливаем сетку по вертикали
        }

        for (int i = 0; i <= HEIGHT * SCALE; i+=SCALE) {
            g.drawLine(0, i, WIDTH * SCALE, i);    //заливаем сетку по горизонтали
        }

        for (int i = 0; i < s.length; i++) {
            g.setColor(color(160, 150, 0)); //рисуем змейку
            g.fillRect(s.snakeX[i] * SCALE + 1, s.snakeY[i] * SCALE + 1, SCALE - 1, SCALE - 1); //отрисовываем змейку по координатам
        }
    }

    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move(); //запускаем змейку

        repaint();//перерисовываем
    }
}
