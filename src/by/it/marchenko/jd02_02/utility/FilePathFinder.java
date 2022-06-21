package by.it.marchenko.jd02_02.utility;

import java.io.File;

public class FilePathFinder {
    public static final String EMPTY_STRING = "";
    public static final String PACKAGE_DIR_SEPARATOR = ".";
    public static final String FILE_EXTENSION_PATTERN = "\\.(.+)";
    public static final String SOURCE_DIR = "src";
    public static final String USER_DIR = "user.dir";


    public static String getFilePath(String fileName) {
        String relativePath = getRelativeFilePath();
        String packageDir = System.getProperty(USER_DIR);
        return packageDir.concat(relativePath).concat(fileName);
    }

    private static String getRelativeFilePath() {
        StackTraceElement callingStackTrace = Thread.currentThread().getStackTrace()[3];
        String callingClass = callingStackTrace.getClassName();
        String callingFileName = callingStackTrace.getFileName();
        String classFileName;
        if (callingFileName != null) {
            classFileName = callingStackTrace.getFileName().replaceAll(FILE_EXTENSION_PATTERN, EMPTY_STRING);
        } else {
            throw new RuntimeException();
        }
        String relPath = callingClass
                .replace(classFileName, EMPTY_STRING)
                .replace(PACKAGE_DIR_SEPARATOR, File.separator);
        return File.separator.concat(SOURCE_DIR).concat(File.separator).concat(relPath);
    }

    public static File getRootFolderPath() {
        return new File(getFilePath(EMPTY_STRING)).getParentFile();
    }
}
