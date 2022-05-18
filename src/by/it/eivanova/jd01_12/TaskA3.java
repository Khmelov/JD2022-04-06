package by.it.eivanova.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        String values = "1 -2 3 0 -4 5 -6 7 0 8 end";
        //[1 2 5 7 8 0 0 -2 -4 -6]
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int posZero = 0;
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt(value);
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
        System.out.println(list);
    }



}
