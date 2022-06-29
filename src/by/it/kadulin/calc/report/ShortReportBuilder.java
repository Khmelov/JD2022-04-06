package by.it.kadulin.calc.report;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ShortReportBuilder extends ReportBuilder{

    @Override
    public void buildTitle() {
        report.setTitle("Short report");
    }

    @Override
    public void buildTimeDateCreate() {
        report.setTimeDateCreate(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
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
