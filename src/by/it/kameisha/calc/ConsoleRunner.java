package by.it.kameisha.calc;

import by.it.kameisha.calc.constants.MessageApp;
import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Repository;
import by.it.kameisha.calc.repository.VarMapRepository;
import by.it.kameisha.calc.service.Parser;
import by.it.kameisha.calc.service.Printer;
import by.it.kameisha.calc.service.VarCreator;

import java.util.*;

public class ConsoleRunner {
    public static final String COMMAND_END = "end";

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : new Locale("en");
        List<String> locales = new ArrayList<>(Arrays.asList("ru", "en", "be"));
        resMan.setLocale(locale);
        Logger logger = Logger.INSTANCE;

        Printer printer = new Printer();
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);

        Scanner scanner = new Scanner(System.in);
        System.out.println(resMan.get(MessageApp.MESSAGE_START_APP));
        System.out.println(DataTime.showDateTime());
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(COMMAND_END)) {
                System.out.println(DataTime.showDateTime());
                break;
            } else if (locales.contains(expression)) {
                locale = new Locale(expression.trim());
                resMan.setLocale(locale);
            } else {
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                    logger.info(result,expression);

                } catch (CalcException e) {
                    printer.print(e);
                    logger.error(e,expression);
                }
            }
        }
        System.out.println(resMan.get(MessageApp.MESSAGE_STOP_APP));
    }
}