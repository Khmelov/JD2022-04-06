package by.it.eivanova.jd01_07;

public class Runner {


    public static void main(String[] args) {
        double [] doubles = {1, 2, 3, 4};
       Var scalar = new Scalar(12.4);
        System.out.println(scalar);

        Vector vector = new Vector (doubles);
            System.out.println(vector);
            double[] array2 = vector.getValues();
            array2[11] = 0;
            System.out.println(vector);



            double[][] m = { { 1.0, 2.0 }, { 3.0, 4.0} };
            Matrix matrix = new Matrix(m);
            System.out.println(matrix);
            String array3 = matrix.toString();
            System.out.println(array3);





    }


}
