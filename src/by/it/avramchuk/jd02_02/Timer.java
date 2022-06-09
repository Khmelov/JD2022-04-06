package by.it.avramchuk.jd02_02;

public class Timer {
    private Timer() {
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
