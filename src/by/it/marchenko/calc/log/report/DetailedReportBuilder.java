package by.it.marchenko.calc.log.report;

public class DetailedReportBuilder extends ReportBuilder {

    @Override
    public void buildHeader() {
        report.setHeader("Мой заголовок");
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
