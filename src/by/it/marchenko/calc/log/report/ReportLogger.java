package by.it.marchenko.calc.log.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public enum ReportLogger implements ReportAction {
    REPORT_LOGGER;
    private final LocalDateTime appStartTime = LocalDateTime.now();
    private final String DATE_TIME_PATTERN = "yyyy/MM/dd: HH:mm:ss";
    private final DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    public LocalDateTime getAppStartTime() {
        return appStartTime;
    }

    public static ReportLogger get() {
        return REPORT_LOGGER;
    }

    private final List<ReportEvent> reportEvents = new LinkedList<>();
    private ReportEvent currentReportEvent;

    @Override
    public String getCurrentTime() {
        return LocalDateTime.now().format(formatDate);
    }

    @Override
    public String getCurrentTime(LocalDateTime instance) {
        return instance.format(formatDate);
    }

    @Override
    public void setInputText(String input) {
        currentReportEvent = new ReportEvent();
        currentReportEvent.setInputExpression(input);
        currentReportEvent.setTimeStamp(getCurrentTime());
    }

    @Override
    public void setResultText(String text) {
        currentReportEvent.setOperationResult(text);
        reportEvents.add(currentReportEvent);
    }

    @Override
    public void setResultText(String text, boolean errorMode) {
        currentReportEvent.setOperationResult(text);
        if (errorMode) {
            currentReportEvent.setErrorEventType();
        }
        reportEvents.add(currentReportEvent);
    }

    public String getOperation() {
        StringJoiner sj = new StringJoiner(NEW_LINE);
        for (ReportEvent reportEvent : reportEvents) {
            sj.add(reportEvent.toString());
        }
        return sj.toString();
    }
}