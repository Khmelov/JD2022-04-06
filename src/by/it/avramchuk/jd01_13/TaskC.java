package by.it.avramchuk.jd01_13;

import java.util.*;
import java.util.Scanner;

public class TaskC {
    static Scanner scanner;
    static List<Double> list =  new ArrayList<>();;
    static int errorsCounter=0;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }

    }

    static void readData(){
        try {
            double value=0;
            while (scanner.hasNext()) {
                value = Double.parseDouble(scanner.next());
                list.add(value);

            }
        }catch (NumberFormatException e){
            if (errorsCounter<4) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                errorsCounter++;
            } else {
                Collections.reverse(list);
                for (Double element : list) {
                    System.out.print(element+ " ");
                }
                throw e;
            }
        }
    }
}
