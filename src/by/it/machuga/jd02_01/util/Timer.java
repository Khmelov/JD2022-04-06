package by.it.machuga.jd02_01.util;

public class Timer {

    private Timer() {
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
