package by.it.smirnov.calc;

import by.it.smirnov.calc.entity.Var;
import by.it.smirnov.calc.exception.CalcException;
import by.it.smirnov.calc.interfaces.Repository;
import by.it.smirnov.calc.repository.PersistentRepository;
import by.it.smirnov.calc.service.Parser;
import by.it.smirnov.calc.service.Printer;
import by.it.smirnov.calc.service.VarCreator;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class ConsoleRunner {

    public static final String USER_DIR = "user.dir";
    static final String start = "Let's get started!\n" +
            "Введите 2 операнда (скаляр, вектор или матрицу) и знак операции между ними (-+* или /).\n для выхода введите \"end\"";
    static final String ending = "App work has successfully ended.\n You're welcome to try again. Have a nice time!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String line;
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Printer printer = new Printer(out);

        out.println(start);

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.equals("end")) {
                out.println(ending);
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
