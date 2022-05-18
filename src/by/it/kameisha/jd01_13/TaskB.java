package by.it.kameisha.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (!input.equals("END")) {
                    int number = Integer.parseInt(input);
                }

            }
        } catch (ArithmeticException e) {
        }
    }
}
