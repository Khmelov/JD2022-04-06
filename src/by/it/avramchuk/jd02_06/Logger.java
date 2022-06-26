package by.it.avramchuk.jd02_06;

import by.it.avramchuk.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class Logger {
    public static final String LOG_TXT = "log.txt";
    private static volatile Logger instance;

    private Logger(){
    }

    public static Logger getLogger(){
        Logger localLogger = instance;
        if (Objects.isNull(localLogger)){
            synchronized (Logger.class){
                localLogger = instance;
                if(Objects.isNull(localLogger)){
                    instance=localLogger=new Logger();
                }
            }
        }
        return localLogger;
    }

    public  void  log(String message){
        String path = Util.getPath(Logger.class, LOG_TXT);
       try (PrintWriter printWriter = new PrintWriter(new FileWriter(path, true))){
           printWriter.println(message);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
