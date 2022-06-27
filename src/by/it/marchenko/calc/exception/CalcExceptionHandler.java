package by.it.marchenko.calc.exception;

import by.it.marchenko.calc.log.EnumLogger;

public class CalcExceptionHandler {
    public void handleCalcException(CalcException e) {
        String message = e.getMessage();
        System.out.println(message);
        EnumLogger.get().error(message);
    }
}
