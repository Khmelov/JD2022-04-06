package by.it.arsenihlaz.calculator;

import by.it.arsenihlaz.calculator.constants.Message;
import by.it.arsenihlaz.calculator.entity.Var;
import by.it.arsenihlaz.calculator.exception.CalcException;
import by.it.arsenihlaz.calculator.interfaces.Repository;
import by.it.arsenihlaz.calculator.repository.VarMapRepository;
import by.it.arsenihlaz.calculator.services.Parser;
import by.it.arsenihlaz.calculator.services.Printer;
import by.it.arsenihlaz.calculator.services.VarCreator;


import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Locale locale;
        ResourceManager resourceManager = ResourceManager.INSTANSE;
        System.out.println(resourceManager.getValue(Message.START));
        System.out.println(resourceManager.getValue(Message.SET_TO_LANGUAGE));

        Printer printer = new Printer(System.out);
        Repository repository = new VarMapRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();


            if (command.equals(resourceManager.getValue(Message.COMMAND_END))) {
                break;
            } else if (command.equals("be")) {
                locale = new Locale("be", "BY");
                resourceManager.setLocale(locale);
                System.out.println(resourceManager.getValue(Message.SET_TO_LANGUAGE));
            } else if (command.equals("en")) {
                locale = new Locale("en", "EN");
                resourceManager.setLocale(locale);
                System.out.println(resourceManager.getValue(Message.SET_TO_LANGUAGE));
            } else if (command.equals("ru")) {
                locale = new Locale("ru", "RU");
                resourceManager.setLocale(locale);
                System.out.println(resourceManager.getValue(Message.SET_TO_LANGUAGE));
            } else {
                try {
                    Var result = parser.calc(command);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            }
        }
    }
}
