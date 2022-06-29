package by.it.edeborg.jd02_01;

public class TimeManage {
    private TimeManage() {
    }

    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout/10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
