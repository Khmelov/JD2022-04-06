package by.it.arsenihlaz.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class RunnerList {
    public static void main(String[] args) {
        List<String> catNameList = new ArrayList<>();
        catNameList.add("Vatrushka");
        catNameList.add("Chernoslivka");
        catNameList.add("Barsik");
        System.out.println(catNameList);
        catNameList.remove(2);
        System.out.println(catNameList);
        System.out.println("Good cat is " + catNameList.get(0));

        catNameList = new ListA<>();
        catNameList.add("Vatrushka");
        catNameList.add("Chernoslivka");
        catNameList.add("Barsik");
        catNameList.add("Ibragim");
        System.out.println(catNameList);
        catNameList.remove(2);
        System.out.println(catNameList);
        System.out.println("Good cat is " + catNameList.get(0));
//        ArrayList<String> catNameList2 = new ArrayList<>();
//        catNameList2.remove(0);
    }
}
