package by.it.ragach.jd01_10;

public class Bean {
    static double sum (int a, int b){
        return a+b;
    }

    @Param(a=100,b=200)
    double max (int a, int b){
        return Math.max(a,b);
    }
    @Param(a=100,b=300)
    static double min (int a, int b) {
        return Math.min(a, b);

    }
    @Param(a=400,b=200)
    double avg (int a,int b){
        return (a+b)/2d;
    }

}
