package by.it.marchenko.calc;

import by.it.marchenko.calc.entity.Var;
import by.it.marchenko.calc.exception.CalcException;
import by.it.marchenko.calc.interfaces.Repository;
import by.it.marchenko.calc.repository.VarRepositoryMap;
import by.it.marchenko.calc.services.*;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {

        Scanner console = new Scanner(System.in);           //  input data source
        Repository repo = new VarRepositoryMap();    //  repository for variable saving
        //VarCreator creator = new VarCreator(repo);          //  variable creator method
        Operands operands = new Operands(repo);             //  create/check String/Var operands and operators
        Assignment assignment = new Assignment(repo);       //  check and perform assignment

        Printer.greeting();

        Input inputString = new Input(console);
        Parser parseString = new Parser(repo/*, creator*/, operands, assignment);

        while (inputString.runEnabled()) {
            inputString.setExpression();
            String tempString = inputString.getExpression();

            CalcCommander commander = new CalcCommander(repo);  //  command creator method
            String resultString = commander.performCommand(tempString);

            if (resultString == null) {
                Var result = parseString.calc(tempString);
                Printer.print(inputString, result);
            } else {
                Printer.print(resultString);
            }
        }
    }
}
