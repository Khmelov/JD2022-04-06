package by.it.marchenko.jd02_05.util;

import java.io.*;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Converter {

    public static final String CODE_POINT_FORMAT = "\\u%04x";
    public static final String ASSIGN_SYMBOL = "=";
    public static final int LIMIT = 2;
    public static final String TXT = "txt";
    public static final String PROPERTIES = "properties";
    public static final String DELIMITER = "\n";
    public static final String FILE_NOT_EXIST = "File not exist";
    public static final String COMMENT_SYMBOL = "#";
    public static final String INCORRECT_INNER_FILE_FORMAT = "Incorrect inner file format";
    public static final String DEFAULT_OUTPUT_DIRECTORY = "language";
    public static final String SOMETHING_WRONG_WITH_RESOURCE_DIRECTORY = "Something wrong with resource directory";
    public static final String DEFAULT_RESOURCE_DIRECTORY = "res";

    public static void createResourceFromText() {
        createResourceFromText(DEFAULT_RESOURCE_DIRECTORY);
    }

    public static void createResourceFromText(String resourceDirectory) {
        File[] resFiles = getResourceFiles(resourceDirectory);
        for (File resFile : resFiles) {
            File outFile = setOutFile(resFile);
            String convertText = readAndConvertResFile(resFile);
            printToFile(outFile, convertText);
        }
    }


    private static File[] getResourceFiles(String resourceDirectory) {
        File resDirectory = new File(FilePathFounder.setResourceDirectory(resourceDirectory));
        File[] resFiles = resDirectory.listFiles();
        if (Objects.isNull(resFiles)) {
            throw new RuntimeException(SOMETHING_WRONG_WITH_RESOURCE_DIRECTORY);
        }
        return resFiles;
    }

    private static File setOutFile(File resFile) {
        return new File(FilePathFounder.setResourceDirectory(DEFAULT_OUTPUT_DIRECTORY) +
                File.separator +
                resFile.getName().replace(TXT, PROPERTIES));
    }

    private static String readAndConvertResFile(File resFile) {
        StringJoiner text = new StringJoiner(DELIMITER);
        try (BufferedReader in = new BufferedReader(new FileReader(resFile))) {
            while (true) {
                String line = in.readLine();
                if (!Objects.isNull(line)) {
                    text.add(convertLine(line));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_EXIST, e);
        }
        return text.toString();
    }

    public static String convertLine(String txtLine) {
        try {
            String[] split = txtLine.split(ASSIGN_SYMBOL, LIMIT);
            return (split.length == LIMIT && !split[0].contains(COMMENT_SYMBOL)) ?
                    split[0] + ASSIGN_SYMBOL + split[1].trim().
                            codePoints().
                            mapToObj(c -> String.format(CODE_POINT_FORMAT, c)).
                            collect(Collectors.joining())
                    : txtLine;
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            throw new RuntimeException(INCORRECT_INNER_FILE_FORMAT, e);
        }
    }

    private static void printToFile(File file, String text) {
        try (PrintWriter out = new PrintWriter(file)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(FILE_NOT_EXIST, e);
        }
    }
}
