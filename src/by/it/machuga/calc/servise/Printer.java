package by.it.machuga.calc.servise;

import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.interfaces.Message;

import java.util.Objects;

import static by.it.machuga.calc.runner.ConsoleRunner.resourceManager;

public class Printer {

    public void print(Var result) {
        if (Objects.nonNull(result)) {
            System.out.printf(resourceManager.get(Message.RESULT_MESSAGE), result);
        } else {
            System.out.println(resourceManager.get(Message.CALCULATION_FAILED_MESSAGE));
        }
    }

    public void print(Exception e) {
        System.out.println(resourceManager.get(Message.ERROR_MSG) + e.getMessage());
    }
}
