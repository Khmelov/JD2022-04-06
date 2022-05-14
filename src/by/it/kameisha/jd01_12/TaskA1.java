package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int count = ThreadLocalRandom.current().nextInt(30, 40);
        for (int i = 0; i < count; i++) {
            int grade = ThreadLocalRandom.current().nextInt(1, 11);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
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
