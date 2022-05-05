package by.it.smirnov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if(line.equals("end")) {
                break;
            }

            else {
                Var result = parser.calc(line);
                printer.print(result);
            }
        }
    }
}
