package by.it.kameisha.jd02_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger{
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
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))) {
            printWriter.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

}
