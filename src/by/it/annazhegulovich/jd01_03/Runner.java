package by.it.annazhegulovich.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String Line= scanner.nextLine();
        double[] array= InOut.getArray(Line);
        InOut.printArray(array);
        Helper.findMin(array);
        Helper.findMax(array);
    }
}
