package by.it.annazhegulovich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);

            double sum = 0;
        double sqrt=0;
        double value = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("END")) {
                    break;
                } else {
                    try {
                    value = Double.parseDouble(line);
                    sum = sum + value;
                    //System.out.println(value);
                    } catch (NumberFormatException|ArithmeticException e){
                        TaskA.showException(e);
                    }
                }
                //sqrt = Math.sqrt(sum);
                if (sum<0){
                    throw new ArithmeticException("вычисление не возможно");
                }
        }
        System.out.println("value " + value +" sqrt "+Math.sqrt(sum));
    }
}

