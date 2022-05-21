package by.it.avramchuk.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        String input = getInput();
        input = input.trim();

        // fdkjndk 1.344 dsl 2 -4 -5.0
        String[]  splitInput = input.split("\s+");

        try{
            double sum=0;
            for (String line : splitInput) {
                double value = Double.parseDouble(line);
                sum += value;
                double sqrt=0;
                if (sum<0){
                    throw new ArithmeticException();
                }else {
                    sqrt = Math.sqrt(sum);
                }
                System.out.printf(Locale.ENGLISH,"""
                        value: %.4f
                          sum: %.4f
                         sqrt: %.4f
                        """, value, sum, sqrt);
            }
        }catch (NumberFormatException | ArithmeticException e){
            showDetails(e);
        }

    }

    private static void showDetails(RuntimeException e) {
        Class<? extends RuntimeException> exClass = e.getClass();
        String exName = exClass.getName();
        Class<TaskB> myClass = TaskB.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            String className = element.getClassName();
            if (className.equals(myClass.getName())){
                int lineNumber = element.getLineNumber();
                System.out.printf("""
                     name: %s
                    class: %s
                     line: %d
                    """, exName, className, lineNumber);
                break;
            }
        }
    }

    static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String str= "";
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")){
                break;
            } else {
                str = str+input+" ";
            }
        }
        return str;
    }
}
