package by.it.smirnov.calc.service;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.repository.PersistentRepository;


import java.util.Locale;
import java.util.Scanner;

import static by.it.smirnov.calc.constants.Wordings.*;
import static by.it.smirnov.calc.service.ResManager.INSTANCE;
import static java.lang.System.in;
import static java.lang.System.out;

public class CommandManager {
    private CommandManager() {
    }

    public static void inputCommand() {
        ResManager manager = INSTANCE;
        Scanner scanner = new Scanner(in);
        String line;
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Printer printer = new Printer(out);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase(END)) {
                printer.println(INSTANCE.getString(ENDING));
                break;
            } else if (line.equalsIgnoreCase(EN)) manager.setLocale(Locale.ENGLISH);
            else if (line.equalsIgnoreCase(RU)) manager.setLocale(new Locale("ru", "RU"));
            else if (line.equalsIgnoreCase(BE)) manager.setLocale(new Locale("be", "BE"));
            else if (line.equalsIgnoreCase(FR)) manager.setLocale(Locale.CANADA_FRENCH);
            else if (line.equalsIgnoreCase(JP)) manager.setLocale(new Locale("jp", "JP"));
            else {
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.print(e);
                }
            }
        }
    }
}
