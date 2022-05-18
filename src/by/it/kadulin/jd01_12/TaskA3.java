package by.it.kadulin.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        String values = "1 -2 0 5 -6 7";
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int posZero = 0;
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt(value);
                if (i < 0) {
                    list.add(i);
                } else if (i == 0) {
                    list.add(posZero, i);
                } else if (i > 0) {
                    list.add(posZero++, i);
                }
            } else {
                break;
            }
        }
        System.out.println(list);
    }

}
