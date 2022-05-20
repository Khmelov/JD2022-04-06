package by.it.ragach.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (!line.equals("end")) {
                try {
                    String[] sentence = line.split("\n");
                    double result = 0;
                    int sum = 0;
                    for (int i = 0; i < sentence.length; i++) {
                        sentence[i] = String.valueOf(Integer.parseInt(sentence[i]));
                        sum = Integer.parseInt(sum+sentence[i]);
                        result = Math.sqrt(sum);
                        System.out.println(sentence);

                    }

                } catch (NumberFormatException|ArithmeticException e) {
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }

    }
}





