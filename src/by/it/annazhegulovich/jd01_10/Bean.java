package by.it.annazhegulovich.jd01_10;

public class Bean {

    @Param(a = 3, b = 5)
    public static double avg(int a, int b) {
        double avg = (a + b) / 2.0;
        return avg;
    }

    @Param(a = 4, b = 6)
    public static double sum(int a, int b) {
        double sum = (a + b);
        return sum;
    }

    @Param(a = 5, b = 7)
    public double max(int a, int b) {
        if (a < b) {
            return b;
        } else return a;
    }

    public double min(int a, int b) {
        if (a > b) {
            return b;
        } else return a;
    }
}
