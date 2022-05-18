package by.it.smirnov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB3 {
    private static String[] manyNames = new String[4096];
    private static ArrayList<String> peoples;
    private static LinkedList<String> peoples1;

    public static void main(String[] args) {
        Arrays.fill(manyNames, 0, 4096, "Michael Angelo Batio");
        peoples = new ArrayList<>(Arrays.asList(manyNames));
        peoples1 = new LinkedList<>(Arrays.asList(manyNames));

        long startTime1 = System.nanoTime();
        String nameWinner = process(peoples);
        long timing1 = System.nanoTime() - startTime1;
        System.out.printf("Winner is - %s%nВремя выполнения метода с ArrayList = %d мкс%n",nameWinner, timing1/1000);

        long startTime2 = System.nanoTime();
        nameWinner = process(peoples1);
        long timing2 = System.nanoTime() - startTime2;
        System.out.printf("Winner is - %s%nВремя выполнения метода с LinkedList = %d мкс",nameWinner, timing2/1000);
    }

    private static String process(ArrayList<String> peoples) {
        for (int i = 0; i < peoples.size() && peoples.size() > 1; i++) {
            if (i + 1 < peoples.size() - 1) peoples.remove(i + 1);
            else if (i == peoples.size() - 1){
                peoples.remove(0);
                i = -1;
            }
            else if (i + 1 == peoples.size() - 1) {
                peoples.remove(i + 1);
                i = -1;
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.offerLast(peoples.pollFirst());
            peoples.pollFirst();
        }
        return peoples.getFirst();
    }
}
