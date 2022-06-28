package by.it.annazhegulovich.jd02_06_b.calc.service;

import by.it.annazhegulovich.jd02_06_b.calc.entity.Var;
import by.it.annazhegulovich.jd02_06_b.calc.exception.CalcException;

import java.io.PrintStream;
import java.util.Objects;

public class Printer {
    private final PrintStream out;
    public Printer (PrintStream out){
        this.out= out;
    }
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
    public void print (CalcException e){
        out.println("ERROR: "+ e.getMessage());
    }
}
