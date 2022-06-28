package by.it.machuga.calc.reporter;

import by.it.machuga.calc.constans.ConstantStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reporter {
    private final List<ReportLine> reportLines = new ArrayList<>();

    private Reporter() {
    }

    public static Reporter getInstance() {
        return ReporterHolder.INSTANCE;
    }

    private static class ReporterHolder {
        private static final Reporter INSTANCE = new Reporter();
    }

    public void collectReportError(String message, Exception exception) {
        ReportLine reportLine = new ReportLine(ConstantStorage.ERROR, message, exception);
        reportLines.add(reportLine);
    }

    public void collectReportInfo(String message) {
        ReportLine reportLine = new ReportLine(ConstantStorage.INFO, message);
        reportLines.add(reportLine);
    }

    public void printReport() {
        System.out.println(ConstantStorage.SELECT_REPORT_TYPE_FULL_OR_SHORT);
        Scanner scanner = new Scanner(System.in);
        String reportType = scanner.next();
        ReportBuilder reportBuilder;
        if (reportType.equalsIgnoreCase(ConstantStorage.FULL)) {
            reportBuilder = new FullReportBuilder();
        } else {
            reportBuilder = new ShortReportBuilder();
        }
        String report = reportBuilder.getReport(reportLines);
        System.out.println(report);
    }
}
