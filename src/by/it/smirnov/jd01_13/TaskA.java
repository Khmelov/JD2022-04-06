package by.it.smirnov.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            print(e);
        }
    }

    static void print(RuntimeException e) {
        StackTraceElement [] stackTraceElement = e.getStackTrace();
        for (StackTraceElement element : stackTraceElement) {
            if(TaskA.class.getName().equals(element.getClassName())) {
                String name = e.getClass().getName();
                String className = element.getClassName();
                int lineNumb = element.getLineNumber();
                System.out.printf("""
                    name: %s
                   class: %s
                    line: %d
                    """,name, className, lineNumb);
                break;
            }
        }
    }
}
