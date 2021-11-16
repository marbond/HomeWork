package lesson01;

/**
 * Класс, который выводит на экран числа от 1 до 100,
 * заменяя числа, кратные 3 и 5, на «Fizz», «Buzz» и «FizzBuzz».
 * @version 1
 * @author Марина Бондарчук
 */
public class ReplacingMultiplesOfThreeAndFive {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                else {
                    System.out.println("Fizz");
                }
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}
