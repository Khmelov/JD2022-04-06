package by.it.ragach.calc;

import java.io.PrintStream;
import java.util.Objects;

public class Printer {
   private final PrintStream out;

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }

    public void print(CalcException e) {
        System.out.println("ERROR: " + e.getMessage());
    }
}
