package by.it.smirnov.calc.report;

import by.it.smirnov.calc.service.ResManager;

import java.util.Objects;
import java.util.StringJoiner;

import static by.it.smirnov.calc.constants.Wordings.*;
import static by.it.smirnov.calc.report.BuilderManager.data;

public class ShortReportBuilder extends Builder {

    public ShortReportBuilder() {
        super();
    }

    @Override
    void fillReport() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(TITLE_SHORT);
        for (ReportPart part : data) {
            if (Objects.nonNull(part.message)) {
                if(part.message.equals(REPORT_START)) joiner.add(ResManager.getDate() + part.message);
                else joiner.add(part.message);
            }
            if (Objects.nonNull(part.exception)) joiner.add("Error: " + part.exception.getClass().getSimpleName());
        }
        joiner.add(ResManager.getDate() + REPORT_END);
        Report.reportText = joiner.toString();
    }
}
