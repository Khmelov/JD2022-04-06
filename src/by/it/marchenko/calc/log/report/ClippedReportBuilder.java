
package by.it.marchenko.calc.log.report;

public class ClippedReportBuilder extends ReportBuilder {

    @Override
    public void buildHeader() {
        report.setHeader("Мой короткий заголовок");
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
