package by.it.marchenko.jd01_12;

public class Timer {
    private long initTime;

    public Timer() {
        this.initTime = System.nanoTime();
    }

    public double getMsTime() {
        double msTime = (System.nanoTime() - this.initTime) / 1000d;
        this.initTime = System.nanoTime();
        return msTime;
    }
}
