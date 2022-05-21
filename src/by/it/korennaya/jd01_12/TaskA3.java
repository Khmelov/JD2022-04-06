package by.it.korennaya.jd01_12;


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int posZero = 0;
        while (in.hasNext()) {
            String value = in.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt((value));
                if (i < 0) {
                    list.add(i);
                } else if (i == 0) {
                    list.add(posZero, i);
                } else {
                    list.add(posZero++, i);
                }

            } else {
                break;
            }
        }
        out.println(list);
    }
}
