package by.it.arsenihlaz.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoples2 = new LinkedList<String>();
        Timer t = new Timer();
        while (peoples.size() < 4097) {
            peoples.add("Вася");
            peoples.add("Петя");
            peoples.add("Таня");
            peoples.add("Оля");
            peoples.add("Ибрагим");
        }
        System.out.println("ArrayList add: " + t);
        while (peoples2.size() < 4097) {
            peoples2.addLast("Вася");
            peoples2.addLast("Петя");
            peoples2.addLast("Таня");
            peoples2.addLast("Оля");
            peoples2.addLast("Ибрагим");
        }
        System.out.println("LinkedList add: " + t);
        System.out.println(peoples.size());
        process(peoples);
        System.out.println("ArrayList remove: " + t);
        process(peoples2);
        System.out.println("LinkedList remove: " + t);
    }

    static String process(ArrayList<String> peoples) {
        int pos = 0;
        while (peoples.size() > 1) {
           // System.out.println(peoples);
            pos = (pos + 1) % peoples.size();
            peoples.remove(pos);
        }
        System.out.println(peoples);
        return String.valueOf(peoples.get(0));
    }

    static String process(LinkedList<String> peoples) {
//        LinkedList<String> survivor = new LinkedList<String>();
//        int g = 0;
//        for (int i = 0; i < peoples.size(); ++i) {
//            g = (g + 2) % (i + 1);
//        }
//        String value = peoples.get(g);
//        survivor.add(value);
//        System.out.println(survivor.get(0));
//        return String.valueOf(survivor.get(0));
        while (peoples.size() > 1) {
            peoples.addLast(peoples.pollFirst());
            peoples.removeFirst();
        }
        System.out.println(peoples);
        return String.valueOf(peoples.get(0));
    }
}
