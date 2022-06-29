package by.it.annazhegulovich.jd02_06_100.calc;

import by.it.annazhegulovich.jd02_06_100.calc.entity.Var;
import by.it.annazhegulovich.jd02_06_100.calc.exception.CalcException;
import by.it.annazhegulovich.jd02_06_100.calc.interfaces.Repository;
import by.it.annazhegulovich.jd02_06_100.calc.repository.PersistentRepository;
import by.it.annazhegulovich.jd02_06_100.calc.service.Parser;
import by.it.annazhegulovich.jd02_06_100.calc.service.Printer;
import by.it.annazhegulovich.jd02_06_100.calc.service.VarCreator;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleRunner {

    public static final String Command_END = "end";
    public static final String Message_START_APP = "App started";
    public static final String Message_STOP_APP = "App finished";

    public static void main(String[] args) {
        SingletonEnum log = SingletonEnum.INSTANCE;
        Printer printer= new Printer(System.out);
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message_START_APP);

        while (scanner.hasNext()){
            String expression = scanner.nextLine();

            ZonedDateTime zone =ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("GMT+3")) ;
            DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm dd:MM:yyyy");

            log.messageToFile(dateTime.format(zone));
            log.messageToFile(expression);

            if (expression.equals(Command_END)){
                break;
            } else{
                try {
                    Var result = parser.calc(expression);
                    printer.print(result);
                   log.messageToFile("Result: "+ result);
                } catch (CalcException e){
            printer.print(e);
            log.messageToFile(String.valueOf(e));
                }
            }
        }
        System.out.println(Message_STOP_APP);
    }


}
