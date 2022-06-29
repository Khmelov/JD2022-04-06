package by.it.kudelko.calc.logger;

import by.it.kudelko.calc.interfaces.Log;
import by.it.kudelko.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Logger implements Log {
    INSTANCE;
    public static final String LOG_TXT = "log.txt";

        public Logger getValue(){
        return INSTANCE;
    }

    public void log(String message) {
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(path, true));
        ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
            String date = LocalDate.now().format(formatter);
            printWriter.printf("%s: %s \n", date, message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void info(String info) {
        log("Information: " + info);
    }

    @Override
    public void error(String error) {
        log("Error: " + error);
    }
}
