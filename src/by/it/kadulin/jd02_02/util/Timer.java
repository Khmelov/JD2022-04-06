package by.it.kadulin.jd02_02.util;

public class Timer {
    private Timer() {

    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
