package by.it.kameisha.calc;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.println(result);
        }
    }

    public void print(CalcException e) {
        System.out.println("ERROR: " + e.getMessage());
    }

    ;
}
