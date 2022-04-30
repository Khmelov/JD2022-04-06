package by.it.smirnov.jd01_08;

public class Runner {

    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);
        String line = "{1,2,4}";
        String matrixLine = "{{1.0, 2.0}, {3.0, 4.0}}";
        double[] vector = {1.0, 2.0, 4.0};
        Var v2 = new Vector(line);
        Var v3 = new Matrix(matrixLine);
        System.out.println(v3);

    }
}
