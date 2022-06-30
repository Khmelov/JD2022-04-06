package by.it.edeborg.jd02_06;


import by.it.edeborg.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

