package by.it.smirnov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    private List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        int range = randomize(20, 40);
        for (int i = 0; i < range; i++) {
            instance.marks.add(randomize(1, 11));
        }
        System.out.println(instance.marks.toString());
        instance.clearBad(instance.marks);
        System.out.println(instance.marks.toString());
    }

    private static int randomize(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    private void clearBad(List<Integer> marks) {
        marks.removeIf(mark -> mark < 4);
    }
}
