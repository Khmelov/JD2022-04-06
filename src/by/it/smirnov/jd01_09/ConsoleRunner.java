package by.it.smirnov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    static final String start = "Let's get started!\n" +
            "Введите 2 операнда (скаляр, вектор или матрицу) и знак операции между ними (-+* или /).\n для выхода введите \"end\"";
    static final String ending = "App work has successfully ended.\n You're welcome to try again. Have a nice time!";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        System.out.println(start);

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if(line.equals("end")) {
                System.out.println(ending);
                break;
            }

            else {
                Var result = parser.calc(line);
                printer.print(result);
            }
        }
    }
}
