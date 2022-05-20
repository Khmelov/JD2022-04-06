package by.it.kudelko.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int posZero = 0;
        while (sc.hasNext()) {
            String value = sc.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt(value);
                if (i < 0) {
                    list.add(i);
                } else if (i == 0) {
                    list.add(posZero, i);
                } else {
                    list.add(posZero++, i);
                }
            }else{
                break;
            }
        }
        System.out.println(list);
    }
}
