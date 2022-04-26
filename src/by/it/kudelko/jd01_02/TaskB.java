package by.it.kudelko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step1();
        step2(month);
        step3(a, b, c);

    }

    static void step1() {
        int n = 5;
        int[][] array = new int[n][n];
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = k++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void step2(int month) {
         String monthString;
        switch (month) {
            case 1:  monthString = "январь";
                break;
            case 2:  monthString = "февраль";
                break;
            case 3:  monthString = "март";
                break;
            case 4:  monthString = "апрель";
                break;
            case 5:  monthString = "май";
                break;
            case 6:  monthString = "июнь";
                break;
            case 7:  monthString = "июль";
                break;
            case 8:  monthString = "август";
                break;
            case 9:  monthString = "сентябрь";
                break;
            case 10: monthString = "октябрь";
                break;
            case 11: monthString = "ноябрь";
                break;
            case 12: monthString = "декабрь";
                break;
            default: monthString = "нет такого месяца";
                break;
        }
        System.out.println(monthString);
    }
    static void step3(double a, double b, double c){
        double D = 0;
        double x1 = 0;
        double x2 = 0;
        D = b*b-4*a*c;
        if (D < 0){
            System.out.println("корней нет");
        }
        else if (D==0) {
                x1 = -b/ (2 * a);
                System.out.println(x1);
            }
            else{
                x1 = (-b + Math.sqrt(D)) / (2 * a);
                x2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.println(x1+" "+x2);
            }
        }
    }