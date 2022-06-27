package by.it.marchenko.calc;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.exception.CalcExceptionHandler;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.log.EnumLogger;
import by.it.marchenko.calc.log.LazyLogger;
import by.it.marchenko.calc.repository.VarRepositoryMap;
import by.it.marchenko.calc.services.*;
import by.it.marchenko.calc.utility.Converter;
import by.it.marchenko.calc.utility.ResourceManager;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleRunner {
    private static final ResourceManager resourceManager = ResourceManager.INSTANCE;
    private static final CalcExceptionHandler calcExceptionHandler = new CalcExceptionHandler();

    public static ResourceManager getResourceManager() {
        return resourceManager;
    }

    public static void main(String[] args) throws CalcException {

        Scanner console = new Scanner(System.in);       //  input data source
        Repository repo = new VarRepositoryMap();       //  repository for variable saving
        //VarCreator creator = new VarCreator(repo);    //  variable creator method
        Operands operands = new Operands(repo);         //  create/check String/Var operands and operators
        Assignment assignment = new Assignment(repo);   //  check and perform assignment
        Converter.createResourceFromText();
        resourceManager.changeResource(Locale.getDefault());
        Printer printer = new Printer(resourceManager);
        EnumLogger enumLogger = EnumLogger.get();


        printer.greeting();
        Input inputString = new Input(console);
        Parser parseString = new Parser(repo/*, creator*/, operands, assignment);

        while (inputString.runEnabled()) {
            try {
                inputString.setExpression();
                String tempString = inputString.getExpression();
                enumLogger.info(tempString);
                LazyLogger.get().info(tempString);

                CalcCommander commander = new CalcCommander(repo);  //  command creator method
                String resultString = commander.performCommand(tempString);

                if (resultString == null) {
                    Var result = parseString.calc(tempString);
                    printer.print(inputString, result);
                } else {
                    Printer.print(resultString);
                }
            } catch (CalcException e) {
                calcExceptionHandler.handleCalcException(e);
            }
        }

    }

}
