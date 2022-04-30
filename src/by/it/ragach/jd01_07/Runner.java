package by.it.ragach.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var var1=new Scalar(12.4);
        Var var2 = new Vector(new double[]{1,2,3,4});
        System.out.println(var1);
        System.out.println(var2);

        Var var3 = new Matrix(new double[][]{{1.0,2.0},{3.0,4.0}});
        System.out.println(var3);



    }
}
