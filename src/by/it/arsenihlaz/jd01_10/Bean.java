package by.it.arsenihlaz.jd01_10;

public class Bean {

    @Param(a=10, b=20)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a=50, b=25)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a=100, b=50)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
