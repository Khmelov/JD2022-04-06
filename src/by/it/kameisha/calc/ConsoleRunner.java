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

        Printer printer = new Printer();
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);

        Scanner scanner = new Scanner(System.in);
        System.out.println(resMan.get(MessageApp.MESSAGE_START_APP));
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(COMMAND_END)) {
                break;
            } else if (locales.contains(expression)) {
                locale = new Locale(expression.trim());
                resMan.setLocale(locale);
            } else {
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            }
        }
        System.out.println(resMan.get(MessageApp.MESSAGE_STOP_APP));
    }
}
