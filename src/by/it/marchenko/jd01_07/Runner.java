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


        //Vector myVector1 = new Vector({1, 2, 3, 4});


    }
}
