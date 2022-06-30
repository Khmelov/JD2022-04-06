package by.it.edeborg.jd01_07;

public class Runner {
    public static void main(String[] args) {
        String line = "1,2,4";
        Var var1 = new Scalar(3.14);
        Var var2 = new Vector(line);
        System.out.println(var1);
        System.out.println(var2);
    }
}


