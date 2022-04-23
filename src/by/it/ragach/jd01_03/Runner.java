package by.it.ragach.jd01_03;

import java.util.Scanner;

@SuppressWarnings("JoinDeclarationAndAssignmentJava")
public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine();
        double [] array = InOut.getArray(line);


        InOut.printArray(array);
        InOut.printArray(array,"А",4);
        double min = Helper.findMin(array);
        double max = Helper.findMax (array);
        array = Helper.sort(array);





    }

}
