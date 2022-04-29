package by.it.machuga.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var scalarDouble = new Scalar(3.1415);
        System.out.println(scalarDouble);

        Var scalarScalar = new Scalar((Scalar) scalarDouble);
        System.out.println(scalarScalar);

        Var scalarString = new Scalar("3.1415");
        System.out.println(scalarString);

        Var vectorDouble = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(vectorDouble);

        Var vectorVector = new Vector((Vector) vectorDouble);
        System.out.println(vectorVector);

        Var vectorString = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vectorString);
    }
}
