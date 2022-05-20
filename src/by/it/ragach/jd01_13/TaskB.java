package by.it.ragach.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;}
            else {
                try {
                    double start = Double.parseDouble(line);
                    sum = sum + start;
                    double result = Math.sqrt(sum);
                    
                } catch (NumberFormatException | ArithmeticException e) {
                    Class<? extends RuntimeException> exceptionClass = e.getClass();
                    Class<TaskB> currentClass = TaskB.class;
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

    }
}





