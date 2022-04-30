package by.it.kudelko.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(3.1415);
        Scalar scalar2 = new Scalar("3.1415");
        System.out.println(scalar1);
        System.out.println(scalar2);

        Vector vector1 = new Vector(new double[]{1,2,4});
        Vector vector2 = new Vector("{1.0,2.0,4.0}");
        System.out.println(vector1);
        System.out.println(vector2);
    }
}
