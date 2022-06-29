package by.it.machuga.jd02_06;

import by.it.machuga.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.util.Objects;

public class Logger implements Log {
    private static volatile Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        Logger localLogger = logger;
        if (Objects.isNull(localLogger)) {
            synchronized (Logger.class) {
                localLogger = logger;
                if (Objects.isNull(localLogger)) {
                    localLogger = new Logger();
                    logger = localLogger;
                }
            }
        }
        return localLogger;
    }

    public void log(String message) {
        String path = Util.getPath(Logger.class, Constants.LOG_TXT);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public void error(String message) {
        String time = ZonedDateTime.now().toString();
        String errorMessage = String.format(Constants.ERROR_MSG, time, message);
        System.err.println(errorMessage);
        log(errorMessage);
    }

    @Override
    public void info(String message) {
        String time = ZonedDateTime.now().toString();
        String infoMessage = String.format(Constants.INFO_MSG, time, message);
        System.out.println(infoMessage);
        log(infoMessage);
    }
}
