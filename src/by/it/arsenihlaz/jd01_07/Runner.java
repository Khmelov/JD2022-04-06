package by.it.arsenihlaz.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var value = new Scalar(3.1415);
        Var strScalar = new Scalar("3.1415");
        Var scalar = new Scalar(3.1415);
        System.out.println(value);
        System.out.println(strScalar);
        System.out.println(scalar);

        Var valueArray = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(valueArray);
        Var valueVector = new Vector("{1.0,2.0,4.0}");
        System.out.println(valueVector);
    }
}
