package by.it.kameisha.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("one"); //0
        list1.add("two"); //1
        list1.add("three"); //2
        list1.add("four"); //3
        list1.add("five"); //
        System.out.println(list1);
        list1.remove(2);
        System.out.println(list1);
        System.out.println(list1.get(2));
        list1.add(4,"six");
        System.out.println(list1);
        ListB<String> list=new ListB<>();
        list.add("one"); //0
        list.add("two"); //1
        list.add("three"); //2
        list.add("four"); //3
        list.add("five"); //
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(2));
        list.add(4,"six");
        System.out.println(list);


    }
}
