package by.it.marchenko.calc.utility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurveChecker {

    private static final HashMap<String, String> curves =
            new HashMap<>(Map.of("{", "}", "[", "]", "(", ")"));


    public boolean checkCurves(String inputData) {
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
