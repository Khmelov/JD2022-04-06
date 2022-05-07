package by.it.marchenko.jd01_10;

@SuppressWarnings("unused")
public class Bean {
    @Param(a = 10, b = 20)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 20, b = 30)
    static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param()
    static double min(int a, int b) {
        return Math.min(a, b);
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
