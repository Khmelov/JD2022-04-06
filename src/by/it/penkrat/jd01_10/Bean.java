package by.it.penkrat.jd01_10;

public class Bean {

    @Param(a=50, b=70)
    public static double sum(int a, int b){
        return a+b;
    }

    @Param(a=150, b=170)
    public double max(int a, int b){
        return Math.max(a, b);
    }
    public static double min(int a, int b){
        return Math.min(a, b);
    }

    @Param(a=350, b=370)
    public double avg(int a, int b){
        return (a+b) / 2d;
    }
}
