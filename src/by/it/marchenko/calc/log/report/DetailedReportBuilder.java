package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.utility.ResourceManager;

public class DetailedReportBuilder extends ReportBuilder
        implements LanguageConst {

    @Override
    public void buildHeader() {
        report.setHeader(ResourceManager.INSTANCE.getString(REPORT_DETAILED_HEADER));
    }

    @Override
    public void buildBody() {

        report.setBody("Мое тело отчета");
    }

    @Override
    public void buildFooter() {
        report.setFooter("Мое окончание отчета");
    }
}
