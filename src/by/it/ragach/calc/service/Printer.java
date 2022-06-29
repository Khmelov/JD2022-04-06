package by.it.ragach.calc.service;

import by.it.ragach.calc.Logger;
import by.it.ragach.calc.ResMan;
import by.it.ragach.calc.constants.Message;
import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;

import java.io.PrintStream;
import java.util.Objects;

public class Printer {

    private final ResMan resMan = ResMan.INSTANCE;
   private final PrintStream out;
   private final Logger logger = Logger.getInstance();

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)){
            out.println(result);
            logger.logInfo(result.toString());
        }
    }

    public void print(CalcException e) {
        out.println(logger.logError(resMan.get(Message.ERROR_MESSAGE)+ " " + e.getMessage()));
    }
}
