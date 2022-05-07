package by.it.machuga.jd01_09;

import java.util.Objects;

public class Printer {

    public void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.printf(ConstantStorage.RESULT_MESSAGE, result);
        } else {
            System.out.println(ConstantStorage.CALCULATION_FAILED_MESSAGE);
        }
    }
}
