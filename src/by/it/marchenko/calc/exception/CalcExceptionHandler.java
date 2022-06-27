package by.it.marchenko.calc.exception;

import by.it.marchenko.calc.log.EnumLogger;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.log.Log;

public class CalcExceptionHandler {
    private final Log logger;

    public CalcExceptionHandler(Log logger) {
        this.logger = logger;
    }

    public String handleCalcException(CalcException e) {
        String message = e.getMessage();
        System.out.println(message);
        logger.error(message);
        return message;
    }
}
