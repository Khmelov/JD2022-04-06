package by.it.marchenko.calc.log.report;

import java.time.LocalDateTime;

public interface ReportAction {
    String getCurrentTime();

    String getCurrentTime(LocalDateTime instance);

    void setInputText(String input);

    void setResultText(String text);

    void setResultText(String text, boolean ErrorMode);
}
