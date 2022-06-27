package by.it.marchenko.calc.log.report;

import java.time.LocalDateTime;

public abstract class ReportBuilder {
    Report report;

    public Report getReport() {
        return report;
    }

    public void createNewReportFile() {
        report = new Report();
    }

    public abstract void buildHeader();

    public abstract void buildBody();

    public abstract void buildFooter();

}
