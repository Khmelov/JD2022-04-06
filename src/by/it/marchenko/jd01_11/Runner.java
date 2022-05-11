package by.it.marchenko.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static final int INITIAL_CAPACITY = 10;
    public static final String FIRST_ELEMENT = "one";
    public static final String SECOND_ELEMENT = "two";
    public static final String THIRD_ELEMENT = "three";
    public static final String FORTH_ELEMENT = "four";
    public static final String FIFTH_ELEMENT = "fife";

    public static void main(String[] args) {
        List<String> stdList = new ArrayList<>(INITIAL_CAPACITY);
        stdList.add(FIRST_ELEMENT);
        stdList.add(SECOND_ELEMENT);
        stdList.add(THIRD_ELEMENT);
        stdList.add(FORTH_ELEMENT);
        stdList.add(FIFTH_ELEMENT);
        System.out.println(stdList);
    }
}
