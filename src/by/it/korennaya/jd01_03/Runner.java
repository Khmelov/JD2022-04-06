package by.it.korennaya.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          String line = scanner.nextLine();
          double[] array = InOut.getArray(line);
          InOut.printArray (array);
          InOut.printArray (array, "A", 3);
          double min = Helper.findMin (array);
          double max = Helper.findMax (array);
          Helper.sort (array);
          }
}
