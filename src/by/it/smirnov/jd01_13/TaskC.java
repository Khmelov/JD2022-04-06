package by.it.smirnov.jd01_13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;

    private static int counter = 0;

    private static String input;

    private static ArrayList<Double> list = new ArrayList<>();

    public static void main(String[] args) throws RuntimeException, InterruptedException, IOException {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() throws RuntimeException, InterruptedException {
        try {
            input = scanner.next();
            double inputD = Double.parseDouble(input);
            list.add(inputD);
            if (counter == 5) throw new RuntimeException();
        } catch (NumberFormatException | NoSuchElementException e) {
            Thread.sleep(100);
            counter++;
            if (counter == 5) throw new RuntimeException();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(list.size()- 1 - i) + " ");
            }
            System.out.println();
        }
    }
}
