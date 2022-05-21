package by.it.machuga.jd01_13;

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
            printException(TaskA.class, e);
        }
    }

    public static void printException(Class<?> taskClass, Exception e) {
        String className = taskClass.getName();
        for (StackTraceElement element : e.getStackTrace()) {
            if (element.getClassName().equals(className)) {
                System.out.printf("""
                                name: %s
                                class: %s
                                line: %d
                                """,
                        e.getClass().getName(),
                        element.getClassName(),
                        element.getLineNumber());
            }
        }
    }
}
