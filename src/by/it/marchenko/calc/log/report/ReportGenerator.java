package by.it.marchenko.calc.log.report;

public enum ReportGenerator {
    INSTANCE;

    public String generateReport() {
        ReportCreator reportCreator = new ReportCreator();
        ReportBuilder reportBuilder = Math.random() > 0.5 ?
                new DetailedReportBuilder() :
                new ClippedReportBuilder();

        reportCreator.setReportBuilder(reportBuilder);
        reportCreator.constructReport();
        Report report = reportBuilder.getReport();
        //System.out.println(report);


        return report.toString();
    }
}
