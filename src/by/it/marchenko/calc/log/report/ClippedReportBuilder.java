
package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.utility.ResourceManager;

public class ClippedReportBuilder extends ReportBuilder
        implements LanguageConst {

    @Override
    public void buildHeader() {
        report.setHeader(ResourceManager.INSTANCE.getString(REPORT_CLIPPED_HEADER));
    }

    @Override
    public void buildBody() {
        report.setBody("Мое короткое тело отчета");
    }

    @Override
    public void buildFooter() {
        report.setFooter("Мое короткое окончание отчета");
    }
}
