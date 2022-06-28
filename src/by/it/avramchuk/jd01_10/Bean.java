package by.it.avramchuk.jd01_10;

public class Bean {
    @Param(a=2, b=4)
    public static double sum (int a, int b){
        double result = a+b;
        return result;
    }
    @Param(a=3, b=5)
    public double max (int a, int b){
        double result = Math.max(a,b);
        return result;
    }

    @Param(a=4, b=6)
    public double min (int a, int b){
        double result = Math.min(a, b);
        return result;
    }
    public static double avg (int a, int b){
        double result = (a+b)/2.0;
        return result;
    }
}
