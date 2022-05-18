package by.it.arsenihlaz.jd01_12;


import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peoples = new ArrayList<>();
        LinkedList<String> peoples2 = new LinkedList<String>();
        while (peoples.size() < 10) {
            peoples.add("Вася");
            peoples.add("Петя");
            peoples.add("Таня");
            peoples.add("Оля");
        }
        while (peoples2.size() < 10) {
            peoples2.add("1");
            peoples2.add("2");
            peoples2.add("3");
            peoples2.add("4");
          }
        process(peoples);
        process(peoples2);
    }

    static String process(ArrayList<String> peoples) {
        int pos = 0;
        while (peoples.size() > 1) {
            System.out.println(peoples);
            pos = (pos + 1) % peoples.size();
            peoples.remove(pos);
        }
        return String.valueOf(peoples.get(0));
        }

    static String process(LinkedList<String> peoples) {
        int pos = 0;
        while (peoples.size() > 1) {
            System.out.println(peoples);
            pos = (pos + 1) % peoples.size();
            peoples.remove(pos);
        }
        return String.valueOf(peoples.get(0));
    }
}
