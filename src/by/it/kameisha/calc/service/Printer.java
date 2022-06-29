package by.it.kameisha.calc.service;

import by.it.kameisha.calc.ResMan;
import by.it.kameisha.calc.constants.Errors;
import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;

import java.util.Objects;

public class Printer {
    private final ResMan resMan = ResMan.INSTANCE;

    public void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.println(result);
        }
    }

    public void print(CalcException e) {
        System.out.println(resMan.get(Errors.MESSAGE_ERROR) + " " + e.getMessage());
    }
}
