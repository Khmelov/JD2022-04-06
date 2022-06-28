package by.it.avramchuk.calc;

import by.it.avramchuk.calc.constants.Message;
import by.it.avramchuk.calc.constants.Patterns;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.interfaces.Repository;
import by.it.avramchuk.calc.logger.*;
import by.it.avramchuk.calc.repository.VarMapRepository;
import by.it.avramchuk.calc.service.Parser;
import by.it.avramchuk.calc.service.Printer;
import by.it.avramchuk.calc.service.VarCreator;
import by.it.avramchuk.calc.util.DateFormatter;
import by.it.avramchuk.calc.util.ResMan;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static final String COMMAND_END = "end";
    public static final String EN = "en";
    public static final String RU = "ru";
    public static final String BE = "be";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        ResMan resMan = ResMan.INSTANCE;
        Logger logger = Logger.getInstance();
        ReportMan reportMan = new ReportMan();

        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(logger.logInfo(resMan.get(Message.START_MESSAGE)));
        logger.logDate();
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            logger.logInfo(expression);
            if (expression.equalsIgnoreCase(EN) ||
                    expression.equalsIgnoreCase(RU) ||
                    expression.equalsIgnoreCase(BE)) {
                Locale locale = new Locale(expression.toLowerCase());
                resMan.setLocale(locale);
                System.out.println(logger.logInfo(resMan.get(Message.LANGUAGE_MESSAGE)));
                continue;
            }
            if (expression.equals(COMMAND_END)) {
                logger.writeTo(Patterns.REPORT_PATH, DateFormatter.getDateTime());
                System.out.println(resMan.get(Message.CHOOSE_REPORT_MESSAGE));
                String input = scanner.nextLine();
                ReportBuilder reportBuilder = input.equals("1") ? new ShortReportBuilder()
                        : new DetailReportBuilder();
                reportMan.setReportBuilder(reportBuilder);
                reportMan.constructReport();
                System.out.println(reportMan.getReport());
                break;
            } else {
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            }

        }
        System.out.println(logger.logInfo(resMan.get(Message.STOP_MESSAGE)));
    }
}
