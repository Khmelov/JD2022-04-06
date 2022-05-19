package by.it.kameisha.jd01_13;

import java.util.*;

public class TaskC {
    static LinkedList<String> consoleStrings = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            consoleStrings.add(scanner.next());
            readData();
        }
    }

    static void readData() throws NumberFormatException {
        try {
            if (consoleStrings.size() != 0) {
                String string = consoleStrings.getLast();
                Double number = Double.parseDouble(string);
            }
        } catch (NumberFormatException e) {
            pause();
            count++;
            consoleStrings.removeLast();
            StringJoiner reversInput = new StringJoiner(" ");
            for (int i = consoleStrings.size() - 1; i >= 0; i--) {
                reversInput.add(consoleStrings.get(i));
            }
            System.out.println(reversInput);
        }
        if (count == 6) {
            throw new NumberFormatException();
        }
    }

    private static void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
