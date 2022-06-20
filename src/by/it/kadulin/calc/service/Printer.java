package by.it.kadulin.calc.service;

import by.it.kadulin.calc.entity.Var;

import java.io.PrintStream;
import java.util.Objects;

public class Printer {

    private final PrintStream out;

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)) {
            out.println(result);
        }
    }
}
