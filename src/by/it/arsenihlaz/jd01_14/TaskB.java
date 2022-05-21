package by.it.arsenihlaz.jd01_14;

import by.it._classwork_.jd01_14.Util;

import java.io.*;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) {
        String pathFile = Util.getPath(TaskB.class, "Poem.txt");
        File poem = new File(pathFile);
        try {
            Scanner scanner = new Scanner(new FileInputStream(poem));
            scanner.useDelimiter("[^а-яА-ЯёЁ]+");
            int counter1 = 0;
            scanner.findInLine("[,.!?;:-]");
            while (scanner.hasNext()) {
                scanner.next();
                counter1++;
            }


            scanner.useDelimiter("\\s?[а-яА-ЯёЁ]+");
            int counter2 = 0;
            while (scanner.hasNext()) {
                Stream<MatchResult> all = scanner.findAll("[,.!?;:-]");
                scanner.next();
                System.out.println(all);
                counter2++;
            }

            System.out.println("words=" + counter1);
            System.out.println("marks=" + counter2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        try {
//            //BufferedReader bufferedReader = new BufferedReader(new FileReader(poem));
//            FileReader fileReader = new FileReader(poem);
//            Scanner scanner = new Scanner(poem);
//          Object delimeter = scanner.useDelimiter("[а-яА-ЯёЁ]+");
//            int counter1 = 0;
//            int counter2 = 0;
//            while (scanner.hasNext()) {
//                //if (scanner.hasNext("[,.!?;:-]\s?")){
//                if (!scanner.next().equals(" ")) {
//                    counter1++;
//                }
//            }
//
//            System.out.println(counter1);
//            System.out.println(counter2);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//    Pattern compile = Pattern.compile("[a-zA-Z']+");
//    Matcher matcher = compile.matcher(pathFile);

    }
}
