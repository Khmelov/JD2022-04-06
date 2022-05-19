package by.it.kadulin.jd01_12;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isRight = true;
        char[] charsArray = sc.nextLine().toCharArray();
        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] == '{' || charsArray[i] == '(' || charsArray[i] == '[') {
                characters.push(charsArray[i]);
            } else if (charsArray[i] == '}') {
                if (characters.size() == 0) {
                    isRight = false;
                } else {
                    if (characters.peekFirst() == '{') {
                        characters.pollFirst();
                    }
                    else {
                        isRight = false;
                    }
                }

            } else if (charsArray[i] == ')') {
                if (characters.size() == 0) {
                    isRight = false;
                } else {
                    if (characters.peekFirst() == '(') {
                        characters.pollFirst();
                    }
                    else {
                        isRight = false;
                    }
                }

            } else if (charsArray[i] == ']') {
                if (characters.size() == 0) {
                    isRight = false;
                } else {
                    if (characters.peekFirst() == '[') {
                        characters.pollFirst();
                    }
                    else {
                        isRight = false;
                    }
                }
            }
        }

        System.out.println(isRight);
    }
}
