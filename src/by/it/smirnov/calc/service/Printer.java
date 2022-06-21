package by.it.smirnov.calc.service;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;

import java.io.PrintStream;
import java.util.Objects;

import static by.it.smirnov.calc.constants.Wordings.ERR;

public class Printer {

    private final PrintStream out;

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)) out.println(result);
    }

    public void print(CalcException e) {
        out.printf(ERR, e.getMessage());
    }
}
