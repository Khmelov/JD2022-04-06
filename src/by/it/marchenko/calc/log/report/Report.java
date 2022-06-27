package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.ConsoleRunner;

import java.time.LocalDateTime;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public class Report {
    ReportLogger reportLogger = ConsoleRunner.getReportLogger();
    public static final int LINE_HIGHLIGHT_LENGTH = 100;
    public static final String LINE_HIGHLIGHT = "-".repeat(LINE_HIGHLIGHT_LENGTH);
    public static final String HEADER_FORMAT = "%%s%%n%%%ds%%n%%s";
    private String header = "";
    private String body = "";
    private String footer = "";

    public void setHeader(String header) {
        int indent = (LINE_HIGHLIGHT_LENGTH + header.length()) / 2;
        String headerFormat = String.format(HEADER_FORMAT, indent);
        this.header = String.format(headerFormat, LINE_HIGHLIGHT, header, LINE_HIGHLIGHT);
    }

    public void setBody(String body) {
        LocalDateTime appStartTime = reportLogger.getAppStartTime();
        String appFinishTime = reportLogger.getCurrentTime();
        String operation = reportLogger.getOperation();

        this.body = body + NEW_LINE + "App Start at:  " + reportLogger.getCurrentTime(appStartTime) +
                NEW_LINE + "App Finish at: " + appFinishTime + NEW_LINE + operation +
                NEW_LINE + LINE_HIGHLIGHT;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return header + NEW_LINE +
                body + NEW_LINE +
                footer;
    }
}
