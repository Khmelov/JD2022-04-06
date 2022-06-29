package by.it.kadulin.calc;

import by.it.kadulin.calc.entity.Var;
import by.it.kadulin.calc.interfaces.Repository;
import by.it.kadulin.calc.report.*;
import by.it.kadulin.calc.repository.PersistentRepository;
import by.it.kadulin.calc.service.*;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String END = "end";
    public static final String MESSAGE_APP_STARTED = "App started";
    public static final String MESSAGE_APP_FINISHED = "App finished";
    public static final String ENTER_EXPRESSION = "enter expression";
    public static final String SELECT_REPORT = "Select type of report\nFull/Short";
    public static final String FULL = "full";
    public static final String SHORT = "short";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner sc = new Scanner(System.in);
        ReportBuilder reportBuilder = null;

        ReportManager reportManager = new ReportManager();

        System.out.println(MESSAGE_APP_STARTED);
        System.out.println(SELECT_REPORT);
        String reportSize = "";
        boolean isFullReport = false;
        while (true) {
            reportSize = sc.nextLine();
            if (reportSize.equalsIgnoreCase(FULL)) {
                reportBuilder = new FullReportBuilder();
                isFullReport = true;
            } else if (reportSize.equalsIgnoreCase(SHORT)) {
                reportBuilder = new ShortReportBuilder();
            }
            if (reportBuilder != null) {
                break;
            }
        }
        reportManager.setReportBuilder(reportBuilder);
        System.out.println(ENTER_EXPRESSION);
        while (sc.hasNext()) {
            String expression = sc.nextLine();
            if (isFullReport && !expression.equalsIgnoreCase(END)) {
                reportBuilder.buildContentAdd(expression);
            }
            if (expression.equals(END)) {
                break;
            } else {
                Var result = parser.startCalc(expression);
                Logger logger = Logger.getInstance();
                logger.log(result.toString());
                reportBuilder.buildContentAdd(result.toString());
                printer.print(result);
            }
        }

        reportManager.constructReport();
        Report report = reportManager.getReport();
        System.out.println(report);
        System.out.println(MESSAGE_APP_FINISHED);
    }
}
