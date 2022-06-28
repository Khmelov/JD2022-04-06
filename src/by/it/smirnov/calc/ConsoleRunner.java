package by.it.smirnov.calc;

import by.it.smirnov.calc.service.ResManager;

import static by.it.smirnov.calc.constants.Wordings.START;
import static by.it.smirnov.calc.service.CommandManager.inputCommand;
import static java.lang.System.out;

public class ConsoleRunner {

    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        out.println(manager.getString(START));
        inputCommand();
    }
}
