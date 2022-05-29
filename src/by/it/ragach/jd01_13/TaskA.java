package by.it.ragach.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if(Math.random()>0.5){
                new HashMap<String,String>(null);

            }else {
                Integer.parseInt("привет");

            }
        }catch (NumberFormatException | NullPointerException e){
            Class<?extends RuntimeException> exceptionClass = e.getClass();
            Class<TaskA>currentClass = TaskA.class;
            String exceptionName = exceptionClass.getName();
            StackTraceElement [] strackTrace =e.getStackTrace();
            for (StackTraceElement element : strackTrace) {
                String classname = element.getClassName();
                if (classname.equals(currentClass.getName())){
                    int lineNumber = element.getLineNumber();
                    System.out.printf("""
                            name: %s
                            class: %s
                            line: %d
                            """, exceptionName, classname,lineNumber);
                    break;
                }
                
            }

        }
    }
}
