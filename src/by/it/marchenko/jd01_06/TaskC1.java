package by.it.marchenko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static final String LINE_PATTERN = "[^\\n]+";
    private static final String SEPARATOR_PATTERN = "\s+";
    private static final String SPACE = " ";


    private static int maxLineLength = 0;

    public static void main(String[] args) {
        String[] lines = getLines();
        for (String line : lines) {
            convertToFixLength(line, maxLineLength);
        }
    }

    private static String[] getLines() {
        Pattern linePattern = Pattern.compile(LINE_PATTERN);
        Matcher lineMatcher = linePattern.matcher(Poem.text);
        String[] lines = {};
        int index = 0;
        while (lineMatcher.find()) {
            lines = Arrays.copyOf(lines, lines.length + 1);
            lines[index] = lineMatcher.group().trim();
            if (lines[index].length() > maxLineLength) {
                maxLineLength = lines[index].length();
            }
            System.out.println(lines[index]);
            index++;
        }
        return lines;
    }

    private static void convertToFixLength(String line, int length) {
        line = line.trim();
        int separatorsToInsert = length - line.length();
        String[] words = line.split(SEPARATOR_PATTERN);
        int separatorAmount = words.length - 1;
        int spaceToInsertAll = separatorsToInsert / separatorAmount + 1;
        int spaceToInsertFirst = separatorsToInsert % separatorAmount;
        StringBuilder correctedLine = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            correctedLine.append(words[i]);
            if (i != words.length - 1) {
                correctedLine.append(SPACE.repeat(spaceToInsertAll));
                if (i < spaceToInsertFirst) {
                    correctedLine.append(SPACE);
                }
            }
        }
        System.out.println(correctedLine);
    }
}
