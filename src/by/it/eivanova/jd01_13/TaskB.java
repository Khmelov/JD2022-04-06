package by.it.eivanova.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;


        //считывает данные из консоли построчно и закрывается при вводе в консоль слова END
        try {
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (!input.equals("END")) {
                    double number = Double.parseDouble(input);
                    sum = sum + number;


                    //   переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
                   // ранее введенных чисел, включая введенное;
                   // если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException

                    double result = Math.sqrt(sum);
                    System.out.println(number);
                    System.out.println(result);
                    if (Double.isNaN(result)) {
                        throw new ArithmeticException();
                    }
                }
            }
        }
        catch (ArithmeticException | NumberFormatException e) {
            Class<TaskB> taskBClass = TaskB.class;
            printExceptionInformation(e, taskBClass);
        }
    }

    public static void printExceptionInformation(RuntimeException e, Class<TaskB> taskClass) {
        Class<? extends RuntimeException> exceptionClass = e.getClass();
        String exceptionName = exceptionClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().equals(taskClass.getName())) {
                int lineNumber = element.getLineNumber();
                System.out.printf(" name: %s%n", exceptionName);
                System.out.printf("class: %s%n", taskClass);
                System.out.printf(" line: %d%n", lineNumber);
                break;
            }
        }
    }





}
