package by.it.machuga.calc.servise;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.entity.Var;

import java.util.Objects;

public class Printer {

    public void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.printf(ConstantStorage.RESULT_MESSAGE, result);
        } else {
            System.out.println(ConstantStorage.CALCULATION_FAILED_MESSAGE);
        }
    }

    public void print(Exception e) {
        System.out.println(ConstantStorage.ERROR_MSG + e.getMessage());
    }
}
