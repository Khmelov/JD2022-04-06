package by.it.smirnov.jd02_01.utils;

public class Sleeper {

    private Sleeper(){}

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
