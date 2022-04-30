package by.it.kameisha.jd01_07;

import java.util.regex.Matcher;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(3.1415);
        Scalar scalar2 = new Scalar(scalar1);
        Scalar scalar3 = new Scalar("3.1415");
        System.out.println(scalar1);
        System.out.println(scalar2);
        System.out.println(scalar3);
        double[] vector = {1.0, 2.0, 4.0};
        Vector vector1 = new Vector(vector);
        Vector vector2 = new Vector(vector1);
        Vector vector3 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);
        double[][] matrix = { { 1.0, 2.0 }, { 3.0, 4.0 } };
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix("{ { 1.0, 2.0 }, { 3.0, 4.0 } }");
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
