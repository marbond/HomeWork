package Lesson03;

/**
 * Класс, который описывает объекты типа Шахматная клетка,
 * с полями: Координата Х, Координата У и Массив названий координат Х
 * с методами: Получить координаты, Изменить координаты, Проверить координаты,
 * Вывести координаты шахматной клетки
 * */

public class ChessСage {

    //Поля
    int x;
    int y;
    private String[] Letters = new String[] {"A", "B", "C", "D","E", "F", "G", "H"};

    //Конструктор
    ChessСage(int x, int y){
        CheckingCoordinates(x, y);
        this.x = x;
        this.y = y;
    }

    //Метод Получить координату x
    int getX() {
        return this.x;
    }

    //Метод Получить координату y
    int getY() {
        return this.y;
    }

    //Метод Изменить координату x
    void setX(int x) {
        CheckingCoordinates(x, this.y);
        this.x = x;
    }

    //Метод Изменить координату y
    void setY(int y) {
        CheckingCoordinates(this.x, y);
        this.y = y;
    }

    //Метод Проверки координат
    void CheckingCoordinates(int x, int y) {
        if ((x < 0 || x > 7) || (y < 0 || y > 7)) {
            throw new IllegalArgumentException("Координаты шахматной клетки неверны, значения должны быть от 0 до 7");
        }

    }

    @Override
    public String toString() {
        return Letters[this.x] + (y + 1);
    }

}
