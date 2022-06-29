package by.it.smirnov.calc.report;

import by.it.smirnov.calc.service.ResManager;

import java.util.Objects;
import java.util.StringJoiner;

import static by.it.smirnov.calc.constants.Wordings.*;
import static by.it.smirnov.calc.report.BuilderManager.data;
import static by.it.smirnov.calc.service.ResManager.INSTANCE;

public class LongReportBuilder extends Builder {
    public LongReportBuilder() {
        super();
    }

    @Override
    void fillReport() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(INSTANCE.getString(TITLE_LONG));
        for (ReportPart part : data) {
            if (Objects.nonNull(part.message)) {
                if(part.message.equals("start")) joiner.add(ResManager.getDate() + " - " + INSTANCE.getString(REPORT_START));
                else joiner.add(part.dateTime + part.message);
            }

            if (Objects.nonNull(part.exception)) {
                joiner.add(part.dateTime + INSTANCE.getString(REPORT_ERROR) + part.exception.getClass().getSimpleName());
                joiner.add("                       " + part.exception.getMessage());
            }
        }
        joiner.add(ResManager.getDate() + " - " + INSTANCE.getString(REPORT_END));
        Report.reportText = joiner.toString();
    }
}
