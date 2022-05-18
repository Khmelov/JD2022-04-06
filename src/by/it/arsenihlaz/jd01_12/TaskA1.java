package by.it.arsenihlaz.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    ArrayList<Integer> grades = new ArrayList<Integer>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();

        for (int i = 0; i < 25; i++) {
            int grade = (int) (Math.random() * 10 + 1);
            instance.grades.add(grade);
        }
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
            if (grade < 4) {
                iterator.remove();
            }
        }
    }
}
