package Lesson06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс, упрощающий относительный путь к файлу
 */

public class SimplifyPath {

    static String homePath(String pathString) {

        Deque<String> deque = new ArrayDeque<>();
        int i = 0;
        StringBuilder w = new StringBuilder();

        while (i < pathString.length()) {
            if (pathString.charAt(i) == '/') {
                updateDeque(w.toString(), deque);
                w = new StringBuilder();
            } else {
                w.append(pathString.charAt(i));
            }
            i++;
        }

        updateDeque(w.toString(), deque);

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0, "/" + deque.pop());
        }

        if (sb.toString().equals("")){
            return "/";
        } else {
            return sb.toString();
        }
    }

    private static void updateDeque(String w, Deque<String> deque) {
        if (w.equals("..") && !deque.isEmpty()) {
            deque.pop();
        }
        if (!w.equals(".") && !w.equals("") && !w.equals("..")) {
            deque.push(w);
        }
    }

    public static void main(String[] args) {
        System.out.println(homePath("КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики"));
    }

}
