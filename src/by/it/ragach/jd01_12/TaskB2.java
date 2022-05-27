package by.it.ragach.jd01_12;

import java.util.*;

public class TaskB2 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String [] peoples = getNames(scanner);

            ArrayList<String>listA = new ArrayList<>(Arrays.asList(peoples));
            System.out.println("Результат с использованием ArrayList " + process(listA));


        }

    private static String[] getNames(Scanner scanner) {
        System.out.println("Введите количество игроков");
            int N = scanner.nextInt();
            String [] names = new String[N];
        for (int i = 0; i < names.length; i++) {
            names[i] = scanner.next();

        }
        return names;
    }


     static String process(ArrayList<String> peoples) {





        return null;
    }

    }









