package by.it._classwork_.jd02_01;

public class Timer {
    private Timer() {
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
