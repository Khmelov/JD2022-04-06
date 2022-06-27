package by.it.smirnov.calc.service;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;

import java.io.PrintStream;
import java.util.Objects;

import static by.it.smirnov.calc.constants.Wordings.ERR;
import static by.it.smirnov.calc.service.Logger.LOG_INSTANCE;
import static by.it.smirnov.calc.service.ResManager.INSTANCE;

public class Printer {

    private final PrintStream out;
    private final Logger logger = LOG_INSTANCE;


    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)) out.println(result);
    }

    public void println(String message) {
        logger.info(message);
        out.println(message);
    }

    public void print(CalcException e) {
        logger.error(INSTANCE.getString(ERR), e);
        out.printf(INSTANCE.getString(ERR), e.getMessage());
    }
}
