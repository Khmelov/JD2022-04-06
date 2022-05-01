package by.it.annazhegulovich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        System.out.println(v1);
        Var v2 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(v2);
        Var v3 = new Matrix(new double[][]{{1, 2},{3, 4}});
        System.out.println(v3);
    }
}
