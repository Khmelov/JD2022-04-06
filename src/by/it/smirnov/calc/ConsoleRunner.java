package by.it.smirnov.calc;

import by.it.smirnov.calc.report.BuilderManager;
import by.it.smirnov.calc.service.Printer;
import by.it.smirnov.calc.service.ResManager;

import static by.it.smirnov.calc.constants.Wordings.START;
import static by.it.smirnov.calc.service.CommandManager.inputCommand;
import static by.it.smirnov.calc.service.ResManager.getDate;
import static java.lang.System.out;

public class ConsoleRunner {

    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        Printer printer = new Printer(out);
        BuilderManager.toReport(getDate(), "start");
        printer.println(manager.getString(START));
        inputCommand();
    }
}
