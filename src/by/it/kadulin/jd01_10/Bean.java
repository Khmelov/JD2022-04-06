package by.it.kadulin.jd01_10;

public class Bean {

    @Param(a= 100, b = 200)
    static double sum(int a, int b) {
        return a+b;
    }

    @Param(a= 400, b = 200)
    static double max(int a, int b) {
        return a>b?a:b;
    }

    @Param(a= 800, b = 200)
    double min(int a, int b) {
        return a<b?a:b;
    }

    double avg(int a, int b) {
        return (a+b)/2d;
    }
}
