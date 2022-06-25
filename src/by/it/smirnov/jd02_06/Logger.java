package by.it.smirnov.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import static by.it.smirnov.jd02_06.PathGetter.getPath;

public class Logger {
    private static volatile Logger logger;

    public static final String LOG_TXT = "log.txt";

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
        String path = getPath(Logger.class, LOG_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
writer.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
