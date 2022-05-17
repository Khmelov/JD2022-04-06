package by.it.marchenko.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    private static final HashMap<String, String> curves =
            new HashMap<>(Map.of("{", "}", "[", "]", "(", ")"));

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputData = getData(console);
        boolean isCorrectCurveFilled = checkCurves(inputData);
        System.out.println("Правильность расстановки скобок: " + isCorrectCurveFilled);
    }

    private static String getData(Scanner source) {
        return source.nextLine();
    }

    private static boolean checkCurves(String inputData) {
        final String CURVE_PATTERN = "[{}()\\[\\]]";
        Pattern curvePattern = Pattern.compile(CURVE_PATTERN);
        Matcher curveMatcher = curvePattern.matcher(inputData);
        LinkedList<String> curveDeque = new LinkedList<>();
        while (curveMatcher.find()) {
            String curve = curveMatcher.group();
            if (curves.containsKey(curve)) {
                curveDeque.addLast(curve);
            } else if (!curveDeque.isEmpty() && curve.equals(curves.get(curveDeque.getLast()))) {
                curveDeque.removeLast();
            } else {
                return false;
            }
        }
        return curveDeque.isEmpty();
    }
}
