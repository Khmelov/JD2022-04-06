package by.it.machuga.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int countGrades = generateRandom(40, 50);
        for (int i = 0; i < countGrades; i++) {
            int grade = generateRandom(1, 11);
            instance.grades.add(grade);
        }
        System.out.println("full grades: " + instance.grades);
        instance.clearBad(instance.grades);
        System.out.println("last grades: " + instance.grades);
    }

    private static int generateRandom(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
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
