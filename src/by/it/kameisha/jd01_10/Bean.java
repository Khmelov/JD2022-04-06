package by.it.kameisha.jd01_10;

public class Bean {
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 100, b = 50)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 10, b = 20)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 30, b = 10)
    double avg(int a, int b) {
        return (a + b) / 2d;
    }
}
