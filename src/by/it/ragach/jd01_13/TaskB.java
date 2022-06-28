package by.it.ragach.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.equals("END")) {
                    break;
                } else {
                    double start = Double.parseDouble(line);
                    sum = sum + start;
                    double result = Math.sqrt(sum);
                    System.out.println(start);
                    System.out.println(result);
                    if (Double.isNaN(result)) {
                        throw new ArithmeticException();
                    }

                }
            }

        } catch (ArithmeticException | NumberFormatException e) {
            Class<TaskB> currentClass = TaskB.class;
            Class<? extends RuntimeException> exceptionClass = e.getClass();
            String exceptionName = exceptionClass.getName();
            StackTraceElement[] strackTrace = e.getStackTrace();
            for (StackTraceElement element : strackTrace) {
                String classname = element.getClassName();
                if (classname.equals(currentClass.getName())) {
                    int lineNumber = element.getLineNumber();
                    System.out.printf("""
                            name: %s
                            class: %s
                            line: %d
                            """, exceptionName, classname, lineNumber);
                }
            }

        }

    }

}









