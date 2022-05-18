package by.it.marchenko.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static final float BORDER = 0.5f;
    public static final String OUT_STRING = "привет";

    public static void main(String[] args) {
        try {
            if (Math.random() > BORDER) {
                //noinspection ConstantConditions
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt(OUT_STRING);
            }
        } catch (NumberFormatException | NullPointerException e) {
            processException(e);
        }
    }

    public static void processException(RuntimeException e) {
        String exceptionName = e.getClass().getName();
        StackTraceElement[] callingStackTrace = Thread.currentThread().getStackTrace();
        String callingName = callingStackTrace[2].getClassName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String exceptionCallingClass = element.getClassName();
            if (exceptionCallingClass.equals(callingName)) {
                int exceptionLine = element.getLineNumber();
                printException(exceptionName, exceptionCallingClass, exceptionLine);
                return;
            }
        }
    }

    private static void printException(String name, String callingClass, int line) {
        final String NAME_HEADER = "name";
        final String CALLING_CLASS_HEADER = "class";
        final String LINE_HEADER = "line";

        System.out.printf("%5s: %s%n", NAME_HEADER, name);
        System.out.printf("%5s: %s%n", CALLING_CLASS_HEADER, callingClass);
        System.out.printf("%5s: %d%n", LINE_HEADER, line);
    }
}
