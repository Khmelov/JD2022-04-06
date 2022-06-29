package by.it.selvanovich.jd02_06;

import by.it.selvanovich.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Objects;

public class Logger implements Log {

    public static final String LOG_TXT = "log.txt";
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

    @Override
    public void logError(String errorMessage){
        log(errorMessage);
    }

    @Override
    public void logInfo(String infoMessage){
        log(infoMessage);
    }

    public void log(String message) {
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (

                PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))
        ) {
            Date date = new Date(System.currentTimeMillis());
            printWriter.println(date + " " + message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
