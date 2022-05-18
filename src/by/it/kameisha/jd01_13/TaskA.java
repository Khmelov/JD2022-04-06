package by.it.kameisha.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (NullPointerException | NumberFormatException e){
            Class<? extends RuntimeException> exceptionClass = e.getClass();
            Class<TaskA> taskAClass = TaskA.class;
            String exceptionName = exceptionClass.getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if(element.getClassName().equals(taskAClass.getName())){
                    int lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s%n",exceptionName);
                    System.out.printf("class: %s%n",taskAClass);
                    System.out.printf(" line: %d%n",lineNumber);
                    break;
                }
            }

        }
    }
}
