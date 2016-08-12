package ua.kruart.snakegame.components;

/**Created by kruart on 12.08.2016.*/
public class Snake {
    public int direction = 0; //направление
    public int length = 10; //длина змейки

    public int snakeX[] = new int[100];
    public int snakeY[] = new int[100];


    public Snake(int x0, int y0, int x1, int y1) {  //координаты начало и конца змейки
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
        snakeX[2] = y1;
        snakeY[2] = y1;
    }

    public void move() {    //метод описывает движение змейки
        for (int i = length; i > 0; i--) {
            snakeX[i] = snakeX[i-1];
            snakeY[i] = snakeY[i-1];
        }

        if(direction == 0) {snakeX[0]++;} //0 - вправо
        if(direction == 1) {snakeY[0]++;} //1 - вниз
        if(direction == 2) {snakeX[0]--;} //2 - влево
        if(direction == 3) {snakeY[0]--;} //3 - вверх

        for (int i = length - 1; i > 0; i--) {
            if ((snakeX[0] == snakeX[i]) && (snakeY[0] == snakeY[i])){  //если голова находиться в одной точке с хвостом, то хвост съедаеться
                if (i - 2 < 3) length = 3;     //минимальный размер 3
                else length = i - 2;           //отрубаем хвост
            }

        }
    }


}
