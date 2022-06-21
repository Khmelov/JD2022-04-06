package by.it.smirnov.calc;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.repository.PersistentRepository;
import by.it.smirnov.calc.service.Parser;
import by.it.smirnov.calc.service.Printer;
import by.it.smirnov.calc.service.VarCreator;

import java.util.Scanner;

import static by.it.smirnov.calc.constants.Wordings.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String line;
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Printer printer = new Printer(out);

        out.println(START);

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.equals(END)) {
                out.println(ENDING);
                break;
            } else {
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    out.println(e.getMessage());
                }
            }
        }
    }
}
