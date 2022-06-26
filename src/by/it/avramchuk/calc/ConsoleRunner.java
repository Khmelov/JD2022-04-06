package by.it.avramchuk.calc;

import by.it.avramchuk.calc.constants.Message;
import by.it.avramchuk.calc.entity.Var;
import by.it.avramchuk.calc.exception.CalcException;
import by.it.avramchuk.calc.interfaces.Repository;
import by.it.avramchuk.calc.repository.VarMapRepository;
import by.it.avramchuk.calc.service.Parser;
import by.it.avramchuk.calc.service.Printer;
import by.it.avramchuk.calc.service.VarCreator;
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

        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(resMan.get(Message.START_MESSAGE));
        while (scanner.hasNext()) {
            String expression = scanner.nextLine();
            if (expression.equalsIgnoreCase(EN) ||
                    expression.equalsIgnoreCase(RU) ||
                    expression.equalsIgnoreCase(BE)) {
                Locale locale = new Locale(expression.toLowerCase());
                resMan.setLocale(locale);
                System.out.println(resMan.get(Message.LANGUAGE_MESSAGE));
                continue;
            }
            if (expression.equals(COMMAND_END)) {
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
        System.out.println(resMan.get(Message.STOP_MESSAGE));
    }
}
