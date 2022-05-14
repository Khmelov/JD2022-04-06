package by.it.marchenko.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static final String INPUT_END_COMMAND = "end";
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        numbers = getNumbers(console);
        System.out.println(numbers);
    }

    private static List<Integer> getNumbers(Scanner console) {
        int currentZeroPosition = 0;
        while (console.hasNext()) {
            String arg = console.next();
            if (!INPUT_END_COMMAND.equalsIgnoreCase(arg)) {
                Integer variable = Integer.parseInt(arg);
                if (variable < 0) {
                    numbers.add(variable);
                } else if (variable > 0) {
                    numbers.add(currentZeroPosition++, variable);
                } else {
                    numbers.add(currentZeroPosition, variable);
                }
            } else {
                break;
            }
        }
        return numbers;
    }
}
