package by.it.edeborg.jd01_13;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TaskC {
    public static final String SPACE = " ";
    static Scanner scanner;
    static Deque<Double> numbers = new ArrayDeque<>();
    static int countException = 0;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        try {
            readData();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void readData() throws Exception {
        while (scanner.hasNext()) {
            String text = scanner.next();
            try
            {
                Double number = Double.parseDouble(text);
                numbers.addFirst(number);
            } catch (NumberFormatException e)
            {
                countException++;
                Thread.sleep(100);
                for (Double number : numbers)
                {
                    System.out.print(number + SPACE);
                }
                System.out.println();
                if (countException >= 5) {
                    throw new Exception();
                }
            }
        }
    }
}