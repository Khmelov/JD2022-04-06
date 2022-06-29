package by.it.kadulin.calc.service;

import by.it.kadulin.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public static class LoggerHolder {
        public static final Logger LOGGER_INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.LOGGER_INSTANCE;
    }

    public static final String LOG_TXT = "log.txt";

    public void log(String message) {
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
