package by.it.marchenko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    public static final int MINIMUM_PUPILS = 30;
    public static final int MAXIMUM_PUPILS = 50;
    public static final int MINIMUM_GRADE = 1;
    public static final int MAXIMUM_GRADE = 10;
    public static final int MINIMUM_ALLOWED_GRADE = 3;

    private List<Integer> gradeList = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        instance.gradeList = instance.getGradeList();
        System.out.println(instance.gradeList);
        instance.clearBad(instance.gradeList);
        System.out.println(instance.gradeList);
    }

    private List<Integer> getGradeList() {
        int pupilAmount = getRandomInt(MINIMUM_PUPILS, MAXIMUM_PUPILS);
        for (int i = 0; i < pupilAmount; i++) {
            int grade = getRandomInt(MINIMUM_GRADE, MAXIMUM_GRADE);
            this.gradeList.add(grade);
        }
        return gradeList;
    }

    private int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    @SuppressWarnings("Java8CollectionRemoveIf")
    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer grade = iterator.next();
            if (MINIMUM_ALLOWED_GRADE >= grade) {
                iterator.remove();
            }
        }
    }
}
