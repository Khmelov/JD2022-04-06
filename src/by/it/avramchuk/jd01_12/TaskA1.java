package by.it.avramchuk.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskA1 {
    private List<Integer> grades= new ArrayList<>();
    public static void main(String[] args) {

        TaskA1 instance = new TaskA1();
        int count= rnd(20,40);
        for (int i = 0; i < count; i++) {
            int grade = rnd(1,11);
            instance.grades.add(grade);
        }
        System.out.println("full grades: "+instance.grades);
        instance.clearBad(instance.grades);
        System.out.println("last grades: "+instance.grades);
        instance.clearBad(instance.grades);


    }

    private static int rnd(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound);
    }


    void clearBad(List<Integer> grades){

        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4){
                iterator.remove();
            }
        }

    }
}
