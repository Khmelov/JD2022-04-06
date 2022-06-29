package by.it.machuga.calc.reporter;

import java.util.List;

import static by.it.machuga.calc.constans.ConstantStorage.EMPTY_STRING;

public abstract class ReportBuilder {
    protected String report = EMPTY_STRING;

    public String getReport(List<ReportLine> reportLineList) {
        addHeader(reportLineList);
        addContent(reportLineList);
        addFooter(reportLineList);
        return report;
    }

    public abstract void addHeader(List<ReportLine> reportLineList);

    public abstract void addContent(List<ReportLine> reportLineList);

    public abstract void addFooter(List<ReportLine> reportLineList);
}
