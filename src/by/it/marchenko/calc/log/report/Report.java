package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.utility.ResourceManager;

import java.time.Duration;
import java.time.LocalDateTime;

import static by.it.marchenko.calc.constant.MessageConst.NEW_LINE;

public class Report implements LanguageConst {
    public static final String FOOTER_TIME_FORMAT = "%-40s %s%n%-40s %s%n%-40s %d %s%n";
    private final ReportLogger reportLogger = ConsoleRunner.getReportLogger();
    private final ResourceManager resourceManager = ConsoleRunner.getResourceManager();
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
        this.body = body + NEW_LINE + LINE_HIGHLIGHT;
    }

    public void setFooter(String footer) {
        LocalDateTime appStartTime = reportLogger.getAppStartTime();
        LocalDateTime appFinishTime = LocalDateTime.now();
        long appProcessTime = Duration.between(appStartTime, appFinishTime).toSeconds();
        resourceManager.getString(REPORT_TOTAL_EVENTS);
        resourceManager.getString(REPORT_ERROR_EVENTS);


        String formattedTimeSentence = String.format(FOOTER_TIME_FORMAT,
                resourceManager.getString(REPORT_APP_START_AT), reportLogger.getTime(appStartTime),
                resourceManager.getString(REPORT_APP_FINISH_AT), reportLogger.getTime(appFinishTime),
                resourceManager.getString(REPORT_APP_PROCESS), appProcessTime,
                resourceManager.getString(REPORT_TIME_UNIT));
        this.footer = footer + NEW_LINE + formattedTimeSentence + LINE_HIGHLIGHT;
    }

    @Override
    public String toString() {
        return header + NEW_LINE + body + NEW_LINE + footer;
    }
}
