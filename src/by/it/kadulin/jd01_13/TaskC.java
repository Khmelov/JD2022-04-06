package by.it.kadulin.jd01_13;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

public class TaskC {

    private static ArrayList<Double> list = new ArrayList<>();
    private static Scanner scan;

    public static void main(String[] args) throws InterruptedException, InputMismatchException {
        scan = new Scanner(System.in);
        readData();
    }

    private static void readData() throws InterruptedException {
//        double input = 0;
        int countOfMistakes = 0;
        while (true) {
            try {
//                input = scan.nextDouble();
//                list.add(input);
                list.add(scan.nextDouble());

            } catch (InputMismatchException e) {
                countOfMistakes++;
                if (countOfMistakes >= 5) {
                    throw new InputMismatchException();
                }
                Thread.sleep(100);
//                StringJoiner sj = new StringJoiner(" ");
                for (int i = list.size() - 1; i >= 0; i--) {
//                    sj.add(list.get(i).toString());
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                scan.next();
//                System.out.println(sj.toString());
            }

        }
    }
}
