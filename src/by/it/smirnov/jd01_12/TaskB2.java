package by.it.smirnov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class TaskB2 {

    private static String[] dreamTheaterCasting = {"Ivanov", "Petrov", "Sidorov", "Johnson", "Jackson",
            "Smith", "Myang", "Petrucci", "Portnoy", "Mangini", "Rudess", "LaBrie", "Sherinian", "Moor"
            , "Dominici"
    };

    private static ArrayList<String> peoples = new ArrayList<>(Arrays.asList(dreamTheaterCasting));

    private static LinkedList<String> peoples1 = new LinkedList<>(Arrays.asList(dreamTheaterCasting));

    public static void main(String[] args) {
        String nameWinner = process(peoples);
        System.out.println(nameWinner);
        nameWinner = process(peoples1);
        System.out.println(nameWinner);
    }

    private static String process(ArrayList<String> peoples) {
        ArrayList<String> copy = new ArrayList<>(peoples);
        for (int i = 0; i < copy.size() && copy.size() > 1; i++) {
            if (i + 1 < copy.size() - 1) copy.remove(i + 1);
            else if (i == copy.size() - 1){
                copy.remove(0);
                i = -1;
            }
            else if (i + 1 == copy.size() - 1) {
                copy.remove(i + 1);
                i = -1;
            }
        }
        return copy.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        LinkedList<String> copy = new LinkedList<>(peoples);
        for (int i = 0; i < copy.size() && copy.size() > 1; i++) {
            if (i + 1 < copy.size() - 1) copy.remove(i + 1);
            else if (i == copy.size() - 1){
                copy.remove(0);
                i = -1;
            }
            else if (i + 1 == copy.size() - 1) {
                copy.remove(i + 1);
                i = -1;
            }
        }
        return copy.get(0);
    }
}
