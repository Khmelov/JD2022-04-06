package by.it.arsenihlaz.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NumberFormatException | NullPointerException e) {
            printException(e);
        }
    }

    protected static void printException(RuntimeException e) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        Class<TaskA> currentClass = TaskA.class;
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(currentClass.getName())){
                int lineNumber = element.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %d
                        """, exceptionName, className, lineNumber);
                break;
            }
        }
    }
}
