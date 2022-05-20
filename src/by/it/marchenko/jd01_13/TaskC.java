package by.it.marchenko.jd01_13;

import java.util.*;

public class TaskC {
    public static final int ALLOWED_INCORRECT_INPUT = 5;
    public static final int SLEEP_TIME_MS = 100;
    public static final String DELIMITER = " ";

    private static short remainingAttempt = ALLOWED_INCORRECT_INPUT;
    static Scanner console;

    public static void main(String[] args) {
        console = new Scanner(System.in);
        try {
            readData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readData() throws InterruptedException, NumberFormatException {
        ArrayDeque<Double> realDeque = new ArrayDeque<>();
        while (remainingAttempt > 0) {
            String element = console.next();
            try {
                realDeque.addFirst(Double.parseDouble(element));
            } catch (NumberFormatException e) {
                processNFE(realDeque);
            }
        }
        throw new NumberFormatException();
    }

    private static void processNFE(ArrayDeque<Double> deque) throws InterruptedException {
        Thread.sleep(SLEEP_TIME_MS);
        if (remainingAttempt-- > 1) {
            ArrayDeque<Double> temp = new ArrayDeque<>(deque);
            StringJoiner outString = new StringJoiner(DELIMITER);
            while (!temp.isEmpty()) {
                outString.add(temp.removeFirst().toString());
            }
            System.out.println(outString);
        }
    }
}