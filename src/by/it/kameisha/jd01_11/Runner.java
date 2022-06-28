package by.it.kameisha.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SetC<Integer> objects = new SetC<>();
        for (int i = 0; i < 10; i++) {
            objects.add(i);
        }
        SetC<Integer> objects1 = new SetC<>();
        for (int i = 6; i < 15; i++) {
            objects1.add(i);
        }
        System.out.println(objects);
        System.out.println(objects.size());
        System.out.println(objects.isEmpty());
        System.out.println(objects.contains(2));
        System.out.println(objects.remove(2));
        System.out.println(objects.contains(2));
        System.out.println(objects);
        System.out.println();
        System.out.println(objects1);
        objects.addAll(objects1);
        System.out.println(objects);
        List<String> list1 = new ArrayList<>();


    }
}
