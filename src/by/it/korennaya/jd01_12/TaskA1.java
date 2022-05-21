package by.it.korennaya.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList();

    public static void main(String[] args) {
        TaskA1 object = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int a = (int) (Math.random() * 10 + 1);
            object.grades.add(a);
        }
        System.out.println(object.grades);

        object.clearBad(object.grades);

        System.out.println(object.grades);
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element <= 3) {
                iterator.remove();
            }
        }
    }
}

