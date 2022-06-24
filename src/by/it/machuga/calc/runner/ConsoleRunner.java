package by.it.machuga.calc.runner;

import by.it.machuga.calc.constans.ConstantStorage;
import by.it.machuga.calc.entity.Var;
import by.it.machuga.calc.exception.CalculatorException;
import by.it.machuga.calc.interfaces.Message;
import by.it.machuga.calc.localization.resourseManager.ResourceManager;
import by.it.machuga.calc.repasitory.PersistentRepository;
import by.it.machuga.calc.repasitory.Repository;
import by.it.machuga.calc.servise.Parser;
import by.it.machuga.calc.servise.Printer;
import by.it.machuga.calc.servise.VarCreator;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResourceManager resourceManager;

    public static void main(String[] args) {
        Locale locale = getLocale();
        resourceManager = getResourceManager(locale);
        System.out.println(resourceManager.get(Message.CALCULATOR_STARTED_MESSAGE));
        Printer printer = new Printer();
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(resourceManager.get(Message.ENTER_EXPRESSION_MESSAGE));
        String expression = scanner.nextLine();
        while (!expression.equalsIgnoreCase(resourceManager.get(Message.END))) {
            try {
                Var result = parser.calc(expression);
                printer.print(result);
            } catch (CalculatorException e) {
                printer.print(e);
            }
            expression = scanner.nextLine();
        }
        System.out.println(resourceManager.get(Message.CALCULATOR_STOPPED_MESSAGE));

    }

    private static Locale getLocale() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConstantStorage.SELECT_LANGUAGE_MSG);
        String language = scanner.next().toLowerCase();
        Locale locale;
        switch (language) {
            case ConstantStorage.RU_LANGUAGE -> locale = new Locale(ConstantStorage.RU_LANGUAGE,
                    ConstantStorage.RU_COUNTRY);
            case ConstantStorage.BE_LANGUAGE -> locale = new Locale(ConstantStorage.BE_LANGUAGE,
                    ConstantStorage.BY_COUNTRY);
            default -> locale = new Locale(ConstantStorage.EN_LANGUAGE, ConstantStorage.US_COUNTRY);
        }
        return locale;
    }

    private static ResourceManager getResourceManager(Locale locale) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.setLocale(locale);
        return resourceManager;
    }
}
