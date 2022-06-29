package by.it.kadulin.calc.report;

public class ReportManager {
    private ReportBuilder reportBuilder;

    public ReportManager() {

    }

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }
    public Report getReport() {
        return reportBuilder.getReport();
    }

    public void constructReport() {
//        reportBuilder.createNewReport();
        reportBuilder.buildTitle();
        reportBuilder.buildTimeDateCreate();
        reportBuilder.buildContent();
    }
}
