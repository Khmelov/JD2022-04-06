package by.it.arsenihlaz.jd02_06;

import by.it.arsenihlaz.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public void error(String messageError) {
        logToFile("ERROR: " + messageError);
    }

    @Override
    public void info(String messageInfo) {
        logToFile("INFO:  " + messageInfo);
    }

    private void logToFile(String message) {
        String path = Util.getPath(Logger.class, "log.txt");
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))
        ) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
            String date = LocalDate.now().format(formatter);
            printWriter.printf("%s: %s \n", date, message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}

