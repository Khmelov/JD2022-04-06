package by.it._classwork_.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                //noinspection ConstantConditions
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
                method();
            }
        } catch (NumberFormatException | NullPointerException e) {
            showDetails(e);

        }
    }

    private static void method() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void showDetails(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskA> currentClass = TaskA.class;
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())) {
                int lineNumber = element.getLineNumber();
                System.out.printf("""
                                 name: %s
                                class: %s
                                 line: %d                            
                                """,
                        exceptionName,
                        className,
                        lineNumber
                );
                break;
            }
        }
    }
}
