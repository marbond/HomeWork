package JavaIO;

/**
 * Класс, который считает кол-во слов в файле
 * @version 1
 * @author Марина Бондарчук
 */

import java.io.*;

public class CountWords {

    public static void main(String[] args) throws IOException
    {
        int chr;
        //Переменная, которая будет содержать предыдущий символ
        int before = 0;
        int words = 1;

        try {
            Reader in = null;
            //Проверка задан ли аргумент
            if (args.length == 0)
                throw new IllegalArgumentException("The command Line argument is not set!");
            else
                in = new FileReader(args[0]);
            //Подсчет слов
            for (int i=0; (chr=in.read()) != -1; i++) {
                //Проверка 3 условий: Является ли символ пробелом, Не повторяется ли символ, Не является ли символ первым
                if (Character.isWhitespace((char) chr) && !(Character.isWhitespace((char) before)) && before != 0) {
                    words++;
                }
                before = chr;
            }
            //Проверка условия: Является ли последний символ пробелом
            if (Character.isWhitespace((char) before)) {
                words--;
            }
            //Вывод кол-ва слов в файле
            System.out.println( "Number of words : "+words);
        }
        //Обработка исключений
        catch (FileNotFoundException e) {
            System.out.println( "File open Error!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
