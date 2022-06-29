package by.it.marchenko.calc.log.report;

public class ReportCreator {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public void constructReport() {
        reportBuilder.createNewReportFile();
        reportBuilder.buildHeader();
        reportBuilder.buildBody();
        reportBuilder.buildFooter();
    }
}
