package by.it.arsenihlaz.calculator.logger;

public class ReportConstructor {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public Report getReportBuilder() {
        return reportBuilder.getReport();
    }


    public void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.buildHeader();
        reportBuilder.buildWorkingTime();
        reportBuilder.buildOperationResult();
    }
}