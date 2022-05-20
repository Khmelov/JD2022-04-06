package by.it.kudelko.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        try {
            while (sc.hasNext()) {
                String value = sc.next();
                if (!value.equals("END")) {
                    double element = Double.parseDouble(value);
                    list.add(element);
                } else {
                    break;
                }
            }
            double b = 0;
            double z ;
            for (Double aDouble : list) {
                b = b + aDouble;
                z = Math.sqrt(b);
                if (Double.isNaN(z)) {
                    throw new ArithmeticException();
                }
                System.out.println(aDouble);
                System.out.println(z);
            }


        } catch (NumberFormatException | NullPointerException | ArithmeticException e) {
            showDetails(e);
        }
    }


    static void showDetails(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskB> currentClass = TaskB.class;
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())) {
                int numberElement = element.getLineNumber();
                System.out.printf(" name: %s%nclass: %s%n line: %d", exceptionName, className, numberElement);
                break;
            }
        }
    }
}
