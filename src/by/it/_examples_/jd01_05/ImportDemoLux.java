package by.it._examples_.jd01_05;


import static java.lang.Math.PI; //для одной константы
import static java.lang.Math.floor; //для одного метода

import static java.lang.Math.*; //для всех статических членов класса Math

public class ImportDemoLux {
    public static void main(String[] args) {
        System.out.println(2 * PI * 3);
        System.out.println(floor(cos(PI / 3)));
    }
}