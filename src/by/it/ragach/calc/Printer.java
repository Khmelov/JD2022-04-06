package by.it.ragach.calc;

import java.util.Objects;

public class Printer {
    public void print(Var result) {
        if (Objects.nonNull(result)){
            System.out.println(result);
        }
    }
}
