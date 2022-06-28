package by.it.marchenko.calc.log.report;

import java.time.LocalDateTime;

public interface ReportAction {
    String getTime();

    String getTime(LocalDateTime instance);

    void setTimeStamp();

    void setInputText(String input);

    void setResultText(String text);

    void setResultText(String text, boolean ErrorMode);

    String getOperation();

    String getOperation(boolean errorMode);
}
