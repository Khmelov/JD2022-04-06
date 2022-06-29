package by.it.machuga.calc.reporter;

import by.it.machuga.calc.constans.ConstantStorage;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.StringJoiner;

import static by.it.machuga.calc.constans.ConstantStorage.NEW_LINE;

public class FullReportBuilder extends ReportBuilder {

    @Override
    public void addHeader(List<ReportLine> reportLineList) {
        ReportLine reportLine = reportLineList.get(0);
        ZonedDateTime time = reportLine.getTime();
        StringBuilder stringBuilder = new StringBuilder(report);
        stringBuilder.append(ConstantStorage.APPLICATION_STARTED_AT_);
        stringBuilder.append(time.toString());
        stringBuilder.append(NEW_LINE);
        report = stringBuilder.toString();
    }

    @Override
    public void addContent(List<ReportLine> reportLineList) {
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        for (ReportLine reportLine : reportLineList) {
            stringJoiner.add(reportLine.toString());
        }
        report = report.concat(stringJoiner.toString()).concat(NEW_LINE);
    }

    @Override
    public void addFooter(List<ReportLine> reportLineList) {
        ReportLine reportLine = reportLineList.get(reportLineList.size() - 1);
        ZonedDateTime time = reportLine.getTime();
        StringBuilder stringBuilder = new StringBuilder(report);
        stringBuilder.append(ConstantStorage.APPLICATION_STOPPED_AT_);
        stringBuilder.append(time.toString());
        stringBuilder.append(NEW_LINE);
        report = stringBuilder.toString();
    }
}
