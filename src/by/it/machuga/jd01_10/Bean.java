package by.it.machuga.jd01_10;

public class Bean {
    @Param(a = 150, b = 250)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 100, b = 300)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 200, b = 400)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    double avg(int a, int b) {
        return (a + b) / 2d;
    }
}
