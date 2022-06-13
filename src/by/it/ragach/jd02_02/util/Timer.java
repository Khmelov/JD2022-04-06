package by.it.ragach.jd02_02.util;

public class Timer {

    private Timer(){

    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout/10);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
