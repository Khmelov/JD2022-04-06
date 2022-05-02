package by.it.avramchuk.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(1);
        System.out.println(scalar1);

        Var scalar2 = new Scalar(scalar1);
        System.out.println(scalar2);

        Var scalar3 = new Scalar("2");
        System.out.println(scalar3);


        Vector vector1 = new Vector(new double[]{3,4});
        System.out.println(vector1);

        Var vector2 = new Vector(vector1);
        System.out.println(vector2);

        Var vector3 = new Vector("{1,3,5}");
        System.out.println(vector3);


        Matrix matrix1 = new Matrix(new double[][]{{7,8},{0,10}});
        System.out.println(matrix1);

        Var matrix2 = new Matrix(matrix1);
        System.out.println(matrix2);

        Var matrix3 = new Matrix("{{34,56}, {178, 24} , {123, 14}}");
        System.out.println(matrix3);


    }
}
