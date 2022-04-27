package by.it.marchenko.jd01_04;

import java.util.Scanner;

public class TaskB {
    final static int QUARTER_QUANTITY = 4;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int personQuantity = console.nextInt();
        String[] persons = new String[personQuantity];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = console.next();
        }
        int[][] quarterSalaries = new int[persons.length][QUARTER_QUANTITY];
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("Введите зарплату для %s%n", persons[i]);
            for (int j = 0; j < QUARTER_QUANTITY; j++) {
                quarterSalaries[i][j] = console.nextInt();
            }
        }
        int[] annualSalaries = calculateAnnualSalaries(quarterSalaries);
        printStatement(persons, quarterSalaries, annualSalaries);
        calculateAverageSalary(annualSalaries);

    }

    private static int[] calculateAnnualSalaries(int[][] salaries) {
        int[] annualSalaries = new int[salaries.length];
        for (int i = 0; i < salaries.length; i++) {
            for (int j = 0; j < salaries[i].length; j++) {
                annualSalaries[i] += salaries[i][j];
            }
        }
        return annualSalaries;
    }

    private static void printStatement(String[] persons, int[][] salaries, int[] total) {
        final int SEPARATOR_WIDTH = 55;
        final String LAST_NAME = "Фамилия";
        final String QUARTER = "Квартал";
        final String TOTAL = "Итого";

        final int STATEMENT_LENGTH = QUARTER_QUANTITY;

        System.out.println("-".repeat(SEPARATOR_WIDTH));
        for (int i = -1; i <= STATEMENT_LENGTH; i++) {
            System.out.printf("%-10s", switch (i) {
                case -1 -> LAST_NAME;
                case STATEMENT_LENGTH -> TOTAL;
                default -> QUARTER + (i + 1);
            });
        }
        System.out.printf("%n%s", "-".repeat(SEPARATOR_WIDTH));
        for (int i = 0; i < persons.length; i++) {
            System.out.printf("%n%9s ", persons[i].concat(":"));
            for (int j = 0; j <= salaries[i].length; j++) {
                if (j == STATEMENT_LENGTH) {
                    System.out.printf("%-10s%n", total[i]);
                } else {
                    System.out.printf("%-10s", salaries[i][j]);
                }
            }
        }
        System.out.printf("%n%s%n", "-".repeat(SEPARATOR_WIDTH));
    }

    private static void calculateAverageSalary(int[] annualSalaries) {
        final String TOTAL = "Итого";
        final String AVERAGE = "Средняя";

        int totalSalary = 0;
        for (int annualSalary : annualSalaries) {
            totalSalary += annualSalary;
        }
        System.out.printf("%-10s%-10d%n", TOTAL, totalSalary);
        double averageSalary = (double) totalSalary / annualSalaries.length / QUARTER_QUANTITY;
        System.out.printf("%-10s%-10.6f%n", AVERAGE, averageSalary);


    }
}
