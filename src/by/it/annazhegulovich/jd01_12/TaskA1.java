package by.it.annazhegulovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
   private List<Integer> grades = new ArrayList<>();

   public static void main(String[] args) {
        TaskA1 instance = new TaskA1();

        int count = random(20,40);
        for (int i = 0; i < count; i++) {
            int grade = random (1, 11);
            System.out.println(grade);
            instance.grades.add(grade);
        }
       System.out.println("Grades all "+instance.grades);
        instance.clearBad(instance.grades);
       System.out.println("Grades remove "+instance.grades);
    }
    public static int random(int from, int to){
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    @SuppressWarnings("Java8CollectionRemoveIf")
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
while (iterator.hasNext()){
    Integer grade = iterator.next();
    if (grade<4){
        iterator.remove();
    }

}
    }
}
