package by.it.kameisha.calc;

import by.it.kameisha.calc.constants.MessageApp;
import by.it.kameisha.calc.entity.Var;
import by.it.kameisha.calc.exception.CalcException;
import by.it.kameisha.calc.interfaces.Repository;
import by.it.kameisha.calc.repository.VarMapRepository;
import by.it.kameisha.calc.service.Parser;
import by.it.kameisha.calc.service.Printer;
import by.it.kameisha.calc.service.VarCreator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss  dd.MM.yyyy")));
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(COMMAND_END)) {
                System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy")));
                break;
            } else if (locales.contains(expression)) {
                locale = new Locale(expression.trim());
                resMan.setLocale(locale);
            } else {
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                    logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss  dd.MM.yyyy")) + "\n\t" + " created "
                            + result.getClass().getSimpleName() + " " + result);

                } catch (CalcException e) {
                    printer.print(e);
                    logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy")) + "\n\t"
                            + e.getClass().getSimpleName() + " " + e.getMessage());
                }
            }
        }
        System.out.println(resMan.get(MessageApp.MESSAGE_STOP_APP));
    }
}