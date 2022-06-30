package by.it.edeborg.jd02_03.util;

public class Timer {

    private Timer() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
