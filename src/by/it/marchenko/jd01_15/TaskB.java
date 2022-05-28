package by.it.marchenko.jd01_15;

import java.io.*;
import java.util.Objects;

public class TaskB {

    public static final String FILE_NOT_FOUND_MESSAGE = "File not found";
    public static final char SLASH = '/';
    public static final char STAR = '*';
        public static final String JAVA = "java";
    public static final String TXT = "txt";

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
            appendLine(code, in);
        } catch (IOException e) {
            throw new RuntimeException(FILE_NOT_FOUND_MESSAGE, e);
        }
        //code = code.deleteCharAt(code.length()-1);
        return code.toString();
    }

    private static void appendLine(StringBuilder code, BufferedReader in) throws IOException {
        boolean multiLineCommentStart = false;
        //boolean firstLine = true;
        while (true) {
            String line = in.readLine();
            if (!Objects.isNull(line)) {
                char charToSearch = multiLineCommentStart ? STAR : SLASH;
                int searchPosition = line.indexOf(charToSearch);
                if (searchPosition >= 0 && searchPosition < line.length() - 1) {
                    char nextSymbolAfterSearch = line.charAt(searchPosition + 1);
                    if (charToSearch == SLASH && nextSymbolAfterSearch == SLASH) {
                        continue;
                    } else if (charToSearch == SLASH && nextSymbolAfterSearch == STAR) {
                        multiLineCommentStart = true;
                        continue;
                    } else if (charToSearch == STAR && nextSymbolAfterSearch == SLASH) {
                        multiLineCommentStart = false;
                        continue;
                    }
                }
                if (!multiLineCommentStart) {
                    code.append(line).append("\n");
                }
            } else {
                break;
            }
        }
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