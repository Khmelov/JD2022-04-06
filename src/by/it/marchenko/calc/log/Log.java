package by.it.marchenko.calc.log;

import java.time.LocalDateTime;

public interface Log {
    void error(String errorMessage);

    void info(String infoMessage);

    void result(String resultMessage);

    //void getTimeStamp();
}
