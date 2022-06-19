package by.it.kudelko.calc.service;

import by.it.kudelko.calc.entity.Var;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
}
