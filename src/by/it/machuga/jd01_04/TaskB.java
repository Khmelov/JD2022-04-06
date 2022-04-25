package by.it.machuga.jd01_04;

import java.util.Scanner;

public class TaskB {
    static Scanner scanner;
    public static final String DELIMITER="--------";
    public static final String LAST_NAME="Фамилия";
    public static final String QUARTER_1="Квартал1";
    public static final String QUARTER_2="Квартал2";
    public static final String QUARTER_3="Квартал3";
    public static final String QUARTER_4="Квартал4";
    public static final String RESULT="Итого";
    public static final String TOTAL="Итого";
    public static final String AVERAGE="Средняя";


    public static void main(String[] args) {
        scanner=new Scanner(System.in);
        int numberPersons=scanner.nextInt();
        String[] lastNames=new String[numberPersons];
        fillStringArray(lastNames);
        int[][] salary=new int[numberPersons][4];
        fillSalaryArray(salary,lastNames);
        printTable(lastNames,salary);
    }

    private static void printTable(String[] lastNames, int[][] salary) {
        printDelimiter(6);
        printHeader();
        printDelimiter(6);
        int totalSum=0;
        for (int i = 0; i < lastNames.length; i++) {
            int personalSum=printPersonalRow(lastNames[i], salary[i]);
            totalSum+=personalSum;
        }
        printDelimiter(6);
        printTotalSum(totalSum);
        double average=(double) totalSum/(lastNames.length*4);
        printAverage(average);
    }

    private static void printAverage(double average) {
        System.out.printf("%-10s%-10.4f%n",TOTAL,average);
    }

    private static void printTotalSum(int totalSum) {
        System.out.printf("%-10s%-10d%n",AVERAGE,totalSum);
    }

    private static int printPersonalRow(String lastName, int[] salary) {
        int personalSum=countPersonalSum(salary);
        System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d%n", lastName +":", salary[0], salary[1], salary[2],
        salary[3],personalSum);
        return personalSum;
    }

    private static int countPersonalSum(int[] salary) {
        int sum=0;
        for (int element : salary) {
            sum+=element;
        }
        return sum;
    }

    private static void printHeader() {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n",LAST_NAME,QUARTER_1,QUARTER_2,QUARTER_3,QUARTER_4,RESULT);
    }

    private static void printDelimiter(int columnCount) {
        for (int i = 0; i <= columnCount; i++) {
            System.out.print(DELIMITER);
        }
        System.out.println();
    }

    private static void fillSalaryArray(int[][] array, String[] names) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите зарплату для %s%n",names[i]);
            fillIntArray(array[i]);
        }
    }

    private static void fillIntArray(int[] ints) {
        for (int j = 0; j < ints.length; j++) {
            ints[j]=scanner.nextInt();
        }
    }

    private static void fillStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]= scanner.next();
        }
    }

}
