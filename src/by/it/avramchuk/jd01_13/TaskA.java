package by.it.avramchuk.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("text");
            }
        } catch (NumberFormatException | NullPointerException e){
            showDetails(e);
        }
    }

    static void showDetails(RuntimeException e) {
        Class<? extends RuntimeException> exClass = e.getClass();
        String exName = exClass.getName();
        Class<TaskA> myClass = TaskA.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(myClass.getName())){
                int lineNumber = element.getLineNumber();
                System.out.printf("""
                         name: %s
                        class: %s
                         line: %d
                        """, exName, className, lineNumber);
                break;
            }
        }
    }
}
