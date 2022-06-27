package by.it.marchenko.calc;

import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.exception.CalcExceptionHandler;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.log.Log;
import by.it.marchenko.calc.log.report.*;
import by.it.marchenko.calc.repository.VarRepositoryMap;
import by.it.marchenko.calc.services.*;
import by.it.marchenko.calc.utility.Converter;
import by.it.marchenko.calc.utility.ResourceManager;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleRunner {
    private static final ReportLogger reportLogger = ReportLogger.get();
    private static final ResourceManager resourceManager = ResourceManager.INSTANCE;
    private static final ReportGenerator reportGenerator = ReportGenerator.INSTANCE;
    private static final Log logger = LazyLogger.get();
    public static final boolean ERROR_MODE = true;
    private static Scanner console;

    public static ResourceManager getResourceManager() {
        return resourceManager;
    }

    public static ReportGenerator getReportGenerator() {
        return reportGenerator;
    }

    public static ReportLogger getReportLogger() {
        return reportLogger;
    }

    public static Scanner getConsole() {
        return console;
    }

    public static void main(String[] args) throws CalcException {


        console = new Scanner(System.in);               //  input data source
        Repository repo = new VarRepositoryMap();       //  repository for variable saving
        Operands operands = new Operands(repo);         //  create/check String/Var operands and operators
        Assignment assignment = new Assignment(repo);   //  check and perform assignment
        CalcExceptionHandler calcExceptionHandler =
                new CalcExceptionHandler(logger);

        Converter.createResourceFromText();
        resourceManager.changeResource(Locale.getDefault());
        Printer printer = new Printer(resourceManager, logger);

        Input inputString = new Input(console);
        Parser parseString = new Parser(repo/*, creator*/, operands, assignment);

        printer.greeting();

        while (inputString.runEnabled()) {
            try {
                inputString.setExpression();
                String tempString = inputString.getExpression();
                logger.info(tempString);
                reportLogger.setInputText(tempString);
                reportLogger.getCurrentTime(LocalDateTime.now());

                CalcCommander commander = new CalcCommander(repo);  //  command creator method
                String resultString = commander.performCommand(tempString);
                String message = Objects.isNull(resultString) ?
                        printer.print(inputString, parseString.calc(tempString)) :
                        printer.print(resultString);

                reportLogger.setResultText(message);
            } catch (CalcException e) {
                String message = calcExceptionHandler.handleCalcException(e);
                reportLogger.setResultText(message, ERROR_MODE);
            }
        }

    }

}
