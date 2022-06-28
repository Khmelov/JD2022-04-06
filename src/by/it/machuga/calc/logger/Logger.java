package by.it.machuga.calc.logger;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.interfaces.Log;
import by.it.machuga.calc.util.PathFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;

public class Logger implements Log {

    private Logger() {
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    private void log(String message) {
        String path = PathFinder.getPath(Logger.class, ConstantStorage.FILENAME);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            error(e.getMessage());
        }
    }

    @Override
    public void error(String message) {
        String time = ZonedDateTime.now().toString();
        String errorMessage = String.format(ConstantStorage.ERROR_FORMAT, time, message);
        System.err.println(errorMessage);
        log(errorMessage);

    }

    @Override
    public void info(String message) {
        String time = ZonedDateTime.now().toString();
        String infoMessage = String.format(ConstantStorage.INFO_FORMAT, time, message);
        System.out.println(infoMessage);
        log(infoMessage);

    }
}
