package by.it.marchenko.calc.log.report;

import by.it.marchenko.calc.ConsoleRunner;
import by.it.marchenko.calc.constant.LanguageConst;
import by.it.marchenko.calc.services.Printer;
import by.it.marchenko.calc.utility.FilePathFounder;
import by.it.marchenko.calc.utility.ResourceManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import static by.it.marchenko.calc.constant.MessageConst.EMPTY_STRING;

public enum ReportGenerator implements LanguageConst {
    INSTANCE;
    private final static ResourceManager resourceManager = ResourceManager.INSTANCE;
    private static final String REPORT_FILE_NAME = "report.txt";
    public static final String REPORT_GENERATED_FORMAT = "%s%n%s";
    private Scanner console;
    private Printer printer;

    public static final String POSITIVE_ANSWER = "1";
    public static final String NEGATIVE_ANSWER = "0";

    public String generateReport() {
        printer = ConsoleRunner.getPrinter();
        console = ConsoleRunner.getConsole();
        ReportCreator reportCreator = new ReportCreator();
        ReportBuilder reportBuilder = isDetailedReportMode() ?
                new DetailedReportBuilder() :
                new ClippedReportBuilder();
        reportCreator.setReportBuilder(reportBuilder);
        reportCreator.constructReport();
        Report report = reportBuilder.getReport();
        if (isSaveToFile()) {
            saveReportToFile(report);
            if (!isPrintToScreen()) {
                return EMPTY_STRING;
            }
        }
        return report.toString();
    }

    private void saveReportToFile(Report report) {
        String reportFile = FilePathFounder.getFilePath(REPORT_FILE_NAME);
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(reportFile))) {
            printWriter.println(report);
            String reportMessage = String.format(REPORT_GENERATED_FORMAT,
                    resourceManager.getString(REPORT_GENERATED_MESSAGE),
                    reportFile);
            printer.println(reportMessage);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private boolean isDetailedReportMode() {
        return getAnswer(REPORT_MODE_QUESTION);
    }

    private boolean isSaveToFile() {
        return getAnswer(REPORT_SAVE_TO_FILE_QUESTION);
    }

    private boolean isPrintToScreen() {
        return getAnswer(REPORT_PRINT_TO_SCREEN_QUESTION);
    }

    private boolean getAnswer(String question) {
        String translatedQuestion = resourceManager.getString(question);
        String questionWithAnswers = String.format(translatedQuestion, POSITIVE_ANSWER, NEGATIVE_ANSWER);
        printer.print(questionWithAnswers + " ");
        // TODO implement answer check
        int mode = console.nextInt();

        return mode % 2 == 1;
    }
}
