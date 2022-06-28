package by.it.ragach.calc;


import by.it.ragach.calc.constants.Message;
import by.it.ragach.calc.constants.Patterns;
import by.it.ragach.calc.entity.Var;
import by.it.ragach.calc.exception.CalcException;
import by.it.ragach.calc.interfaces.Repository;
import by.it.ragach.calc.repository.PersistentRepository;
import by.it.ragach.calc.repository.VarMapRepository;
import by.it.ragach.calc.service.Parser;
import by.it.ragach.calc.service.Printer;
import by.it.ragach.calc.service.VarCreator;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {


    public static final String COMMAND_END = "end";
    public static final String MESSAGE_START_APP= "App started";
    public static final String MESSAGE_STOP_APP = "App finished";

    public static final String EN = "en";
    public static final String RU = "ru";
    public static final String BE = "be";

    public static void main(String[] args) {
        Printer printer = new Printer(System.out);
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        ResMan resMan = ResMan.INSTANCE;
        Logger logger = Logger.getInstance();



        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(logger.logInfo(resMan.get(Message.START_MESSAGE)));
        logger.logDate();

        while (scanner.hasNext()){
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(EN)||
                    expression.equalsIgnoreCase(RU)||
                    expression.equalsIgnoreCase(BE)){
                Locale locale = new Locale(expression.toLowerCase());
                resMan.setLocale(locale);
                System.out.println(logger.logInfo(resMan.get(Message.LANGUAGE_MESSAGE)));
                continue;

            }
            if (expression.equals(COMMAND_END)){
               logger.writeTo(Patterns.REPORT_PATH,DateFormatter.getDateTime());
               break;
            }else {
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
