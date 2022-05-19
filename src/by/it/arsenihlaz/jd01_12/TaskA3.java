package by.it.arsenihlaz.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        String values = "-2 2 1 -1 8 12 7 4 0 -18 -5 9 end";
        //               2,1,8,12,7,4,9,0,-2,-1,18,-5
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int positionZero = 0;
        while (scanner.hasNext()) {
            String value = scanner.next();
            if (!value.equals("end")) {
                int i = Integer.parseInt(value);
                if (i==0){
                    numbers.add(positionZero,i);
                }else if (i<0){
                    numbers.add(i);
                }else numbers.add(positionZero++,i);
            } else break;
        }
        System.out.println(numbers);
    }
}
