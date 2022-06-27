package by.it.smirnov.calc.service;

import by.it.smirnov.calc.interfaces.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static by.it.smirnov.calc.util.PathGetter.getPath;

public enum Logger implements Log {

    LOG_INSTANCE;

    private static volatile Logger logger;

    public static final String LOG_TXT = "log.txt";


    public static Logger getLogInstance() {
        return LOG_INSTANCE;
    }

    public void log(String message) {
        String path = getPath(Logger.class, LOG_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        String errorMessage = String.format("%s:%n%s%n%s%n%s", message, ResManager.getDate(), e.getClass().getSimpleName(), e.getMessage());
        log(errorMessage);
    }

    @Override
    public void info(String message) {
        log(message + "\nMessage date: " + ResManager.getDate());
    }
}
