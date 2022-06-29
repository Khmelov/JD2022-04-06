package by.it.kadulin.calc.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FullReportBuilder extends ReportBuilder{

    @Override
    public void buildTitle() {
        report.setTitle("Full report");
    }

    @Override
    public void buildTimeDateCreate() {
        report.setTimeDateCreate(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    }

    @Override
    public void buildContentAdd(String text) {
        report.contentAdd(text);
    }

    @Override
    public void buildContent() {
        report.getContent();
    }
}
