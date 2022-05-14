package by.it.kameisha.jd01_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[a-zA-Z']+");

        Matcher matcher = pattern.matcher(scanner.next(pattern));


    }
}
