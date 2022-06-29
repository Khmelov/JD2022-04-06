package by.it.avramchuk.calc.service;

import by.it.avramchuk.calc.constants.Message;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.logger.Logger;
import by.it.avramchuk.calc.util.ResMan;

import java.io.PrintStream;
import java.util.Objects;

public class Printer {

    private final ResMan resMan = ResMan.INSTANCE;
    private final PrintStream out;
    private final Logger logger= Logger.getInstance();

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if(Objects.nonNull(result)){
            out.println(result);
            logger.logInfo(result.toString());
        }
    }

    public void print(CalcException e) {
        out.println(logger.logError(resMan.get(Message.ERROR_MESSAGE)+" "+e.getMessage()));
    }
}
