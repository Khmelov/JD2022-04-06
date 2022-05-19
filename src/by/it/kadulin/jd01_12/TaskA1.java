package by.it.kadulin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < rnd(20, 41); i++) {
            taskA1.grades.add(rnd(1, 11));
        }
        System.out.println(taskA1.grades);
        taskA1.clearBad(taskA1.grades);
        System.out.println(taskA1.grades);
//        System.out.println(0%2);
    }

    private static int rnd(int low, int high) {
        return ThreadLocalRandom.current().nextInt(low, high);
    }

    private void clearBad(List<Integer> marks) {
        marks.removeIf(next -> next < 4);
    }
}
