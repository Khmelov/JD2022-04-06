package by.it._examples_.jd01_09.funcdemo;

public class Run {
    public static void main(String[] args) {
        Parser parser = (s) -> s + "ok";
        String hi = parser.parse("hi");
        System.out.println(hi);
    }
}
