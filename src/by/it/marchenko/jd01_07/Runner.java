package by.it.marchenko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var myVar1 = new Scalar(3.14);
        System.out.println(myVar1);
        Var myVar2 = new Scalar("2.15");
        System.out.println(myVar2);
        Scalar myVar3 = new Scalar("2.158");
        System.out.println(myVar3);
        Scalar myVar4 = new Scalar(myVar3);
        System.out.println(myVar4);
        double d = myVar4.getValue();

        double[] myArrayVector = {1,2,3,4};
        Vector myVector0 = new Vector(myArrayVector);
        Vector myVector1 = new Vector(myVector0);
        Vector myVector2 = new Vector("{1    ,2,                 3.1}");

        System.out.println(myVector0);
        System.out.println(myVector1);
        System.out.println(myVector2);

        double[][] myArrayMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix myMatrix0 = new Matrix(myArrayMatrix);
        Matrix myMatrix1 = new Matrix(myMatrix0);
        String s = "     { {    2.0, 3.0,  4.0            }  ,   {  4.0,  5.0  , 6.0 } ,  {   7.0, 8.0, 9.0  }    }   ";
        Matrix myMatrix2 = new Matrix(s);




        System.out.println(myMatrix0);
        System.out.println(myMatrix1);
        System.out.println(myMatrix2);



        //Vector myVector1 = new Vector({1, 2, 3, 4});


    }
}
