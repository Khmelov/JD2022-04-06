package by.it.smirnov.jd01_12;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    private static List<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) {
        fillByScanner(numberList);
        System.out.println(numberList.toString());
        segregation(numberList);
        System.out.println(numberList.toString());
    }

    private static void fillByScanner (List<Integer> numberList) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true){
            line = scanner.nextLine();
            if (line.equals("end")) break;
            numberList.add(Integer.parseInt(line));
        }
    }

    private static void segregation(List<Integer> numberList) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(numberList);
        for (Integer numb : copy) {
            if (numb < 0) {
                numberList.remove(numb);
                negatives.add(numb);
            }
            else if (numb == 0) {
                numberList.remove(numb);
                negatives.add(0,numb);
            }
        }
        numberList.addAll(negatives);
    }
}
