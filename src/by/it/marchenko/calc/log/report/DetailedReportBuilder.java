package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.utility.ResourceManager;

public class DetailedReportBuilder extends ReportBuilder
        implements LanguageConst {
    private static final String FOOTER_FORMAT = "%-40s %d%n%-40s %d";
    private final ReportLogger reportLogger = ConsoleRunner.getReportLogger();
    private final ResourceManager resourceManager = ConsoleRunner.getResourceManager();

    @Override
    public void buildHeader() {
        report.setHeader(resourceManager.getString(REPORT_DETAILED_HEADER));
    }

    @Override
    public void buildBody() {
        report.setBody(reportLogger.getOperation());
    }

    @Override
    public void buildFooter() {
        int totalEvents = reportLogger.getTotalEventsCount().intValue();
        int errorEvents = reportLogger.getErrorEventsCount().intValue();
        String formattedFooter = String.format(FOOTER_FORMAT,
                resourceManager.getString(REPORT_TOTAL_EVENTS), totalEvents,
                resourceManager.getString(REPORT_ERROR_EVENTS), errorEvents);
        report.setFooter(formattedFooter);
    }
}