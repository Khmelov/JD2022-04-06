package by.it.avramchuk.calc.logger;

public class ReportMan {
    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb){
        reportBuilder=rb;
    }
    public Report getReport(){
        return reportBuilder.getReport();
    }

    public void constructReport(){
        reportBuilder.createNewReport();
        reportBuilder.addTitle();
        reportBuilder.addBody();
        reportBuilder.addEnding();
    }
}
