package by.it.penkrat.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var v1 = new Scalar(3.1415);
        Var v2 = new Scalar(new Scalar(3.1415));
        Var v3 = new Scalar("3.1415");

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        double[] value = {1, 2, 4};

        Var vector1 = new Vector(value);
        Var vector2 = new Vector(new Vector(value));
        Var vector3 = new Vector("{1,  2,  4, 0, 55}");

        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        double[][] valueNew = {{1.0, 2.0}, {3.0, 4.0}};

        Var matrix1 = new Matrix(valueNew);
        Var matrix2 = new Matrix(new Matrix(valueNew));
        Var matrix3 = new Matrix("{{1,2,3},{3,4,5}}");
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}








