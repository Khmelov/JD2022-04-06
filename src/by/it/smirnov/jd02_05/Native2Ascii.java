package by.it.smirnov.jd02_05;

import java.io.*;
import java.util.StringJoiner;

public class Native2Ascii {

    public static final String FILE_NAME_INPUT = "txtfiles%stext_%s.txt";
    public static final String FILE_NAME_OUTPUT = "language%stext_%s.properties";
    private static final String PREFIX = "\\u";

    public static void main(String[] args) {
        for (String arg : args) {
            convertFile(arg);
        }
    }

    private static void convertFile(String lang) {
        String fileNameIn = String.format(FILE_NAME_INPUT, File.separator, lang);
        String fileNameOut = String.format(FILE_NAME_OUTPUT, File.separator, lang);
        String pathIn = PathGetter.getPath(Native2Ascii.class, fileNameIn);
        String pathOut = PathGetter.getPath(Native2Ascii.class, fileNameOut);
        File converted = new File(pathOut);

        try (var reader = new BufferedReader(new FileReader(pathIn));
        var writer = new BufferedWriter (new FileWriter(pathOut, true))) {
            var joiner = new StringJoiner("\n");
            converted.createNewFile();
            while (reader.ready()) {
                String line = reader.readLine();
                line = native2Ascii(line);
                joiner.add(line);
            }
            writer.write(joiner.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String native2Ascii(String line) {
        char[] chars = line.toCharArray();
        var sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(char2Ascii(aChar));
        }
        return sb.toString();
    }

    private static String char2Ascii(char c) {
        if (c > 255) {
            var sb = new StringBuilder();
            sb.append(PREFIX);
            int code = (c >> 8);
            String temp = Integer.toHexString(code);
            if (temp.length() == 1) {
                sb.append("0");
            }
            sb.append(temp);
            code = (c & 0xFF);
            temp = Integer.toHexString(code);
            if (temp.length() == 1) {
                sb.append("0");
            }
            sb.append(temp);
            return sb.toString();
        } else {
            return Character.toString(c);
        }
    }
}