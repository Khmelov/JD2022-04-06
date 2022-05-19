package by.it.arsenihlaz.Calculator;

public class Printer {
    public static void print(Var result) {
        System.out.println("Результат: " + result);
    }

    public void print(CalcException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
