package by.it._examples_.jd01_10.reflection;

@SuppressWarnings("all")
public class HowGetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c;             //переменная для структуры
        //1. Object.getClass()
        c = "foo".getClass();           //java.lang.String
        c = System.out.getClass();      //java.io.PrintStream
        byte[] bytes = new byte[1024];
        c = bytes.getClass();           //[B
        //2. .class Syntax
        boolean b;   //c = b.getClass(); - compile-time error
        c = boolean.class;              //boolean
        c = void.class;                 //void
        c = java.io.PrintStream.class;  //java.io.PrintStream
        c = int[][][].class;            //[[[I
        //3. Class.forName()
        c = Class.forName("java.lang.Object"); //java.lang.Object
        c = Class.forName("java.lang.String"); //java.lang.String
        //4. TYPE Field for Primitive Type Wrappers
        c = Double.TYPE;                //double
        c = Void.TYPE;                  //void
    }

}
