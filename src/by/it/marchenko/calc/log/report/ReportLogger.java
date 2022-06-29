package by.it.marchenko.calc.log.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public enum ReportLogger implements ReportAction {
    REPORT_LOGGER;
    private final AtomicInteger totalEventsCount = new AtomicInteger(0);
    private final AtomicInteger errorEventsCount = new AtomicInteger(0);
    private final LocalDateTime appStartTime = LocalDateTime.now();
    private final String DATE_TIME_PATTERN = "yyyy/MM/dd - HH:mm:ss";
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
    public String getTime() {
        return LocalDateTime.now().format(formatDate);
    }

    @Override
    public String getTime(LocalDateTime instance) {
        return instance.format(formatDate);
    }

    @Override
    public void setTimeStamp() {
        currentReportEvent = new ReportEvent();
        currentReportEvent.setTimeStamp(getTime());
    }

    @Override
    public void setInputText(String input) {
        input = Objects.nonNull(input) ? input : "";
        currentReportEvent.setInputExpression(input);
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

    @Override
    public String getOperation() {
        StringJoiner sj = new StringJoiner(NEW_LINE);
        for (ReportEvent reportEvent : reportEvents) {
            sj.add(reportEvent.toString());
            totalEventsCount.getAndIncrement();
            if (reportEvent.getType().equals(ReportEvent.EventType.ERROR)) {
                errorEventsCount.getAndIncrement();
            }
        }
        return sj.toString();
    }

    @Override
    public String getOperation(boolean errorMode) {
        StringJoiner sj = new StringJoiner(NEW_LINE);
        for (ReportEvent reportEvent : reportEvents) {
            if (reportEvent.getType().equals(ReportEvent.EventType.ERROR)) {
                sj.add(reportEvent.toString());
                totalEventsCount.getAndIncrement();
                errorEventsCount.getAndIncrement();
            }
        }
        return sj.toString();
    }

    public AtomicInteger getTotalEventsCount() {
        return totalEventsCount;
    }

    public AtomicInteger getErrorEventsCount() {
        return errorEventsCount;
    }
}