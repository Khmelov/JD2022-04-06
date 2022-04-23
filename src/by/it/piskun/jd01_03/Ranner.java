package by.it.piskun.jd01_03;

import java.util.Scanner;

public class Ranner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line =scanner.nextLine();
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",4);
        //Second part
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        }
}
