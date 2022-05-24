package by.it.marchenko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {

        Repository repo = new VarRepositoryMap();   //  repository for variable saving
        VarCreator creator = new VarCreator(repo);  //  variable creator method
        CalcCommander commander = new CalcCommander(repo);  //  command creator method


        Printer.greeting();
        Scanner console = new Scanner(System.in);
        Input inputString = new Input(console);


        Parser parseString = new Parser(repo, creator);

        while (inputString.runEnabled()) {
            inputString.setExpression();
            String tempString = inputString.getExpression();
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
