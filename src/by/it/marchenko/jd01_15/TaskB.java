
package by.it.marchenko.jd01_15;
//qwe

import java.io.*;

import static by.it.marchenko.jd01_15.StatusWord.*;

public class TaskB {

    public static final String FILE_NOT_FOUND_MESSAGE = "File not found";
    public static final char SLASH = '/';
    public static final char STAR = '*';
    public static final char END_LINE = '\n';
    public static final String JAVA = "java";
    public static final String TXT = "txt";
    private static final StatusWord sw = new StatusWord();

    /**
     * JavaDoc Comments for removing
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        //  first single line comment for removing
        String codeFileName = findCurrentFileName();
        //  second single line comment for removing
        String code = readCodeWithoutComments(codeFileName);
         /*  first multi line comment for removing
            bla-bla-bla         */
        String textFileName = codeFileName.replace(JAVA, TXT);
        /*  second multi line comment for removing
            foo-foo-foo
        */
        printToFile(textFileName, code);
        System.out.println(code);
    }

    private static String findCurrentFileName() {
        StackTraceElement callingStackTrace = Thread.currentThread().getStackTrace()[2];
        return callingStackTrace.getFileName();
    }

    private static String readCodeWithoutComments(String fileName) {
        String filePath = Util.getFilePath(fileName);
        StringBuilder code = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            appendText(code, in);
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_FOUND_MESSAGE, e);
        }
        return code.toString();
    }

    private static void appendText(StringBuilder code, BufferedReader in) throws IOException {
        String buffer = "";
        while (true) {
            int readCode = in.read();
            if (readCode < 0) {
                break;
            }
            char symbol = (char) readCode;
            String beforeStatusWord = sw.getStatusWordValue();
            String afterStatusWord = changeStatusWord(symbol);
            if ((CODE_SW.equals(afterStatusWord) && CODE_SW.equals(beforeStatusWord)) ||
                    (POSSIBLE_COMMENT_START_SW.equals(beforeStatusWord) && CODE_SW.equals(afterStatusWord))) {
                code.append(buffer).append(symbol);
                buffer = "";
            } else if (POSSIBLE_COMMENT_START_SW.equals(afterStatusWord)) {
                buffer = String.valueOf(symbol);
            } else if (SINGLE_LINE_COMMENT_SW.equals(afterStatusWord) ||
                    MULTI_LINE_COMMENT_SW.equals(afterStatusWord)) {
                buffer = "";
            } else if (SINGLE_LINE_COMMENT_SW.equals(beforeStatusWord) && CODE_SW.equals(afterStatusWord)) {
                code.append(symbol);
            }
        }
    }

    private static String changeStatusWord(char symbol) {
        String currentStatusWord = sw.getStatusWordValue();
        if (symbol == SLASH) {
            if (CODE_SW.equals(currentStatusWord)) {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_START);
            } else if (POSSIBLE_COMMENT_START_SW.equals(currentStatusWord)) {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_START);
                sw.changeStatusWordBit(SINGLE_LINE_COMMENT_START);
            } else if (POSSIBLE_COMMENT_END_SW.equals(currentStatusWord)) {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_FINISH);
                sw.changeStatusWordBit(MULTI_LINE_COMMENT_START);
            } else {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_START);
            }
        } else if (symbol == STAR) {
            if (POSSIBLE_COMMENT_START_SW.equals(currentStatusWord)) {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_START);
                sw.changeStatusWordBit(MULTI_LINE_COMMENT_START);
            } else if (MULTI_LINE_COMMENT_SW.equals(currentStatusWord)) {
                sw.changeStatusWordBit(POSSIBLE_COMMENT_FINISH);
            }
        } else if (symbol == END_LINE && SINGLE_LINE_COMMENT_SW.equals(currentStatusWord)) {
            sw.changeStatusWordBit(SINGLE_LINE_COMMENT_START);
        } else {
            sw.setStatusWordBit(POSSIBLE_COMMENT_START, FALSE);
            sw.setStatusWordBit(POSSIBLE_COMMENT_FINISH, FALSE);
        }
        //currentStatusWord = sw.getStatusWordValue();
        return sw.getStatusWordValue();
    }

    private static void printToFile(String fileName, String text) {
        String filePath = Util.getFilePath(fileName);
        try (PrintWriter out = new PrintWriter(filePath)) {
            out.println(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(FILE_NOT_FOUND_MESSAGE, e);
        }
    }
}