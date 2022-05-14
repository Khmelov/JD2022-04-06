package by.it.kameisha.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        int posZero = 0;
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt(value);
                if (i < 0) {
                    input.add(i);
                } else if (i == 0) {
                    input.add(posZero, i);
                } else {
                    input.add(posZero++, i);
                }
            }
        }
        System.out.println(input);
    }
}
