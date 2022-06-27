package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.utility.ResourceManager;

public enum ReportGenerator implements LanguageConst {
    INSTANCE;

    public String generateReport() {
        ReportCreator reportCreator = new ReportCreator();
        ReportBuilder reportBuilder = isDetailedReportMode() ?
                new DetailedReportBuilder() :
                new ClippedReportBuilder();

        reportCreator.setReportBuilder(reportBuilder);
        reportCreator.constructReport();
        Report report = reportBuilder.getReport();
        return report.toString();
    }

    private boolean isDetailedReportMode() {
        String answer1 = "1";
        String answer2 = "0";
        String modeQuestion = ResourceManager.INSTANCE.getString(REPORT_MODE_QUESTION);
        String questionWithAnswers = String.format(modeQuestion, answer1, answer2);
        System.out.print(questionWithAnswers + " ");

        // TODO implement answer check
        int mode = ConsoleRunner.getConsole().nextInt();
        return mode % 2 == 1;
    }
}
