package by.it.edeborg.jd02_02.util;

public class TimeManage {
    private TimeManage() {
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout/100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
