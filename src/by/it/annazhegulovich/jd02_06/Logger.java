package by.it.annazhegulovich.jd02_06;

import by.it.annazhegulovich.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger {
    public static final String LOG_TXT="log.txt";
    private static volatile Logger logger;

    private Logger() {
    }

    public static Logger getInstance(){
        Logger locflLogger = logger;
        if (Objects.isNull(locflLogger)){
            synchronized (Logger.class){
                locflLogger = logger;
                if (Objects.isNull(locflLogger)){
                    locflLogger = new Logger();
                    logger = locflLogger;
                }
            }
        }
        return locflLogger;
    }

    public void log(String message){
        String path = Util.getPath(Logger.class, LOG_TXT);
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))){
            writer.println(message);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
