package by.it.kadulin.calc.report;

import by.it.kadulin.calc.report.Report;

public abstract class ReportBuilder {
    Report report = new Report();

    Report getReport() {
        return report;
    }

//    public void createNewReport() {
//        report = new Report();
//    }

    public abstract void buildTitle();
    public abstract void buildTimeDateCreate();
    public abstract void buildContentAdd(String text);

    public abstract void buildContent();
}
