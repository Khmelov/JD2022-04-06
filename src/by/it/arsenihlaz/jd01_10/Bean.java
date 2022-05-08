package by.it.arsenihlaz.jd01_10;

public class Bean {

    @Param(a = 10, b = 20)
    public static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 50, b = 25)
    public static double max(int a, int b) {
        return Math.max(a, b);
    }

    public double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 100, b = 50)
    public double avg(int a, int b) {
        return (a + b) / 2.0;
    }
    
//    @Param(a = 100, b = 0)
//    public double sin(int a) {
//        return Math.sin(a);
//    }
}
