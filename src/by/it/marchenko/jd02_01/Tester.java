package by.it.marchenko.jd02_01;

public class Tester {
    public static void main(String[] args) {
        Good good1 = new Good(1, "Pizza", 1.20d, "BYN");
        Good good2 = new Good(1_999_999_999, "Golden bread with diamond milk and silver core", 10000.457d);
        System.out.println(good1);
        System.out.println(good2);
        new StringBuilder();
    }
}
