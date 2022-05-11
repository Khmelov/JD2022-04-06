package by.it.korennaya.jd01_10;

public class Bean {

@Param(a = 3, b = 4)
static double sum(int a, int b) {
    return (double) a + b;
}

    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a = 6, b = 8)
    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 25, b = 24)
    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}



