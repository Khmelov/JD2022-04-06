package by.it.machuga.calc.reporter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;

import static by.it.machuga.calc.constans.ConstantStorage.*;

public class ShortReportBuilder extends ReportBuilder {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_TIME);

    @Override
    public void addHeader(List<ReportLine> reportLineList) {
        ReportLine reportLine = reportLineList.get(0);
        ZonedDateTime time = reportLine.getTime();
        StringBuilder stringBuilder = new StringBuilder(report);
        stringBuilder.append(APPLICATION_STARTED_AT_);
        stringBuilder.append(dateTimeFormatter.format(time));
        stringBuilder.append(NEW_LINE);
        report = stringBuilder.toString();
    }

    @Override
    public void addContent(List<ReportLine> reportLineList) {
        StringJoiner stringJoiner = new StringJoiner(NEW_LINE);
        for (ReportLine reportLine : reportLineList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(reportLine.getType());
            stringBuilder.append(EMPTY_SPACE);
            stringBuilder.append(dateTimeFormatter.format(reportLine.getTime()));
            stringBuilder.append(EMPTY_SPACE);
            stringBuilder.append(reportLine.getMessage());
            stringJoiner.add(stringBuilder.toString());
        }
        report = report.concat(stringJoiner.toString()).concat(NEW_LINE);
    }

    @Override
    public void addFooter(List<ReportLine> reportLineList) {
        ReportLine reportLine = reportLineList.get(reportLineList.size() - 1);
        ZonedDateTime time = reportLine.getTime();
        StringBuilder stringBuilder = new StringBuilder(report);
        stringBuilder.append(APPLICATION_STOPPED_AT_);
        stringBuilder.append(dateTimeFormatter.format(time));
        stringBuilder.append(NEW_LINE);
        report = stringBuilder.toString();
    }
}
