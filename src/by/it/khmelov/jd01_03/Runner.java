package by.it.khmelov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array=InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"A",4);
        boolean arrayContainTwo = false;
        for (double element : array) {
            if (element==2){
                arrayContainTwo=true;
            }
        }
        if (arrayContainTwo){
            System.out.println("array contains 2");
        }
    }
}
