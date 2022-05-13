package by.it.marchenko.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static final String FIRST_ELEMENT = "one";
    public static final String SECOND_ELEMENT = "two";
    public static final String THIRD_ELEMENT = "three";
    public static final String FORTH_ELEMENT = "four";
    public static final String FIFTH_ELEMENT = "five";

    public static void main(String[] args) {
        List<String> stdList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            stdList.add(FIRST_ELEMENT);
            stdList.add(SECOND_ELEMENT);
            stdList.add(THIRD_ELEMENT);
            stdList.add(FORTH_ELEMENT);
            stdList.add(FIFTH_ELEMENT);
        }
        List<String> myListA = new ListA<>();
        for (int i = 0; i < 1; i++) {
            myListA.add(FIRST_ELEMENT);
            myListA.add(SECOND_ELEMENT);
            myListA.add(THIRD_ELEMENT);
            myListA.add(FORTH_ELEMENT);
            myListA.add(FIFTH_ELEMENT);
        }
        List<String> myListB = new ListB<>();
        for (int i = 0; i < 1; i++) {
            myListB.add(FIRST_ELEMENT);
            myListB.add(SECOND_ELEMENT);
            myListB.add(THIRD_ELEMENT);
            myListB.add(FORTH_ELEMENT);
            myListB.add(FIFTH_ELEMENT);
        }

        System.out.println("Add   " + "-".repeat(50));
        System.out.println("stdList: " + stdList);
        System.out.println("myListA: " + myListA);
        System.out.println("myListB: " + myListB);

        stdList.remove(2);
        myListA.remove(2);
        myListB.remove(2);
        System.out.println("Remove" + "-".repeat(50));
        System.out.println("stdList: " + stdList);
        System.out.println("myListA: " + myListA);
        System.out.println("myListB: " + myListB);

        System.out.println("Get   " + "-".repeat(50));
        System.out.printf("stdList: First: %-7s Last:%-7s OutOfRange: %-7s%n",
                stdList.get(0), stdList.get(stdList.size() - 1), "error");
        System.out.printf("myListA: First: %-7s Last:%-7s OutOfRange: %-7s%n",
                myListA.get(0), myListA.get(myListA.size() - 1), myListA.get(myListA.size() - 1));
        System.out.printf("myListB: First: %-7s Last:%-7s OutOfRange: %-7s%n",
                myListB.get(0), myListB.get(myListB.size() - 1), myListB.get(myListB.size() - 1));

        System.out.println("Set   " + "-".repeat(50));
        System.out.printf("stdList: Changed: %-7s List: %-85s OutOfRange: %-7s%n",
                stdList.set(2, THIRD_ELEMENT), stdList, "error");
        System.out.printf("myListB: Changed: %-7s List: %-85s OutOfRange: %-7s%n",
                myListB.set(2, THIRD_ELEMENT), myListB, myListB.set((myListB.size()), FIRST_ELEMENT));

        System.out.println("Add(i)" + "-".repeat(50));
        stdList.add(3, FORTH_ELEMENT);
        myListB.add(3, FORTH_ELEMENT);
        System.out.printf("StdList: %s%n", stdList);
        System.out.printf("myListB: %s%n", myListB);

        System.out.println("AddAll" + "-".repeat(50));
        List<String> listToAdd = new ArrayList<>();
        listToAdd.add("Volvo");
        listToAdd.add("BMW");
        listToAdd.add("Toyota");
        stdList.addAll(listToAdd);
        myListB.addAll(listToAdd);
        System.out.printf("StdList: %s%n", stdList);
        System.out.printf("myListB: %s%n", myListB);

        System.out.println("AddAll(i)" + "-".repeat(47));
        stdList.addAll(4, listToAdd);
        myListB.addAll(4, listToAdd);
        System.out.printf("StdList: %s%n", stdList);
        System.out.printf("myListB: %s%n", myListB);

        System.out.println("contains" + "-".repeat(48));
        String search1 = FIFTH_ELEMENT;
        String search2 = "abc";
        System.out.printf("StdList: Search: %-7s List: %-85s Result: %-7s%n",
                search1, stdList, stdList.contains(search1));
        System.out.printf("myListB: Search: %-7s List: %-85s Result: %-7s%n",
                search1, myListB, myListB.contains(search1));
        System.out.printf("StdList: Search: %-7s List: %-85s Result: %-7s%n",
                search2, stdList, stdList.contains(search2));
        System.out.printf("myListB: Search: %-7s List: %-85s Result: %-7s%n",
                search2, myListB, myListB.contains(search2));

        System.out.println("indexOf" + "-".repeat(49));
        System.out.printf("StdList: Search: %-7s List: %-85s Result: %-7d%n",
                search1, stdList, stdList.indexOf(search1));
        System.out.printf("myListB: Search: %-7s List: %-85s Result: %-7d%n",
                search1, myListB, myListB.indexOf(search1));
        System.out.printf("StdList: Search: %-7s List: %-85s Result: %-7d%n",
                search2, stdList, stdList.indexOf(search2));
        System.out.printf("myListB: Search: %-7s List: %-85s Result: %-7d%n",
                search2, myListB, myListB.indexOf(search2));

        System.out.println("Size()" + "-".repeat(50));
        System.out.printf("StdList: List: %-85s Size: %-7d%n", stdList, stdList.size());
        System.out.printf("myListB: List: %-85s Size: %-7d%n", myListB, myListB.size());

        System.out.println("Remove()" + "-".repeat(48));
        boolean b1 = stdList.remove(search1);
        boolean b2 = myListB.remove(search1);
        System.out.printf("StdList: Remove: %-7s List: %-85s Result: %s%n", search1, stdList, b1);
        System.out.printf("myListB: Remove: %-7s List: %-85s Result: %s%n", search1, myListB, b2);
        b1 = stdList.remove(search2);
        b2 = myListB.remove(search2);
        System.out.printf("StdList: Remove: %-7s List: %-85s Result: %s%n", search2, stdList, b1);
        System.out.printf("myListB: Remove: %-7s List: %-85s Result: %s%n", search2, myListB, b2);

        HashSet<String> stdSet = new HashSet<>();
        stdSet.add(FIRST_ELEMENT);
        stdSet.add(SECOND_ELEMENT);
        stdSet.add(THIRD_ELEMENT);
        stdSet.add(FORTH_ELEMENT);
        stdSet.add(FIFTH_ELEMENT);
        stdSet.add(FIRST_ELEMENT);

        SetC<String> mySetC = new SetC<>();
        mySetC.add(FIRST_ELEMENT);
        mySetC.add(SECOND_ELEMENT);
        mySetC.add(THIRD_ELEMENT);
        mySetC.add(FORTH_ELEMENT);
        mySetC.add(FIFTH_ELEMENT);
        mySetC.add(FIRST_ELEMENT);

        System.out.println(stdSet);
        System.out.println(mySetC);


    }
}
