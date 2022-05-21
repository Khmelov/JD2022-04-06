package by.it.kadulin.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {


        if (Math.random() > 0.5) {
            new HashMap<String, String>(null);
        }
        else {
            Integer.parseInt("привет");
        }
        }
        catch (NumberFormatException | NullPointerException e) {
            exceptionProcessing(e);

        }
    }

    static void exceptionProcessing(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskA> currentClass = TaskA.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        String name = exceptionClass.getName();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String exceptionName = stackTraceElement.getClassName();
            if (exceptionName.equals(currentClass.getName())) {
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %s
                        """,
                        name,
                        exceptionName,
                        lineNumber);

                break;
            }
        }
    }
}
