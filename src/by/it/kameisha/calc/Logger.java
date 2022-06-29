package by.it.kameisha.calc;

import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum Logger implements Log {
    INSTANCE;
    public static final String LOG_TXT = "log.txt";

    public void log(String message) {
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void error(CalcException e, String expression) {
        log(DataTime.showDateTime() + "\n\tInput: '" + expression + "'\n\t"
                + e.getClass().getSimpleName() + ": " + e.getMessage());
    }

    @Override
    public void info(Var result, String expression) {
        log(DataTime.showDateTime() + "\n\tInput: '" + expression + "'\n\t" + "Created "
                + result.getClass().getSimpleName() + " " + result);
    }
}
