package by.it.marchenko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static by.it.marchenko.jd01_15.Constants.*;

public class TaskC {
    public static final int GROUP_LENGTH = 3;
    public static final String CURRENT_DIRECTORY = ".";
    public static final String PARENT_DIRECTORY = "..";
    private static File currentDirectory;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        CommandFinder commandFinder = new CommandFinder();
        Util utility = new Util();

        System.out.println(GREETING_MESSAGE);
        currentDirectory = utility.getCurrentFolderPath();

        while (true) {
            System.out.print(currentDirectory + ">");
            String commandline = console.nextLine();
            LinkedList<String> commandList = commandFinder.findCommand(commandline);

            String command = commandList.getFirst();
            String argument = commandList.getLast();
            if (EXIT_APP_COMMAND.equalsIgnoreCase(command) && EMPTY_STRING.equals(argument)) {
                System.out.println(FAREWELL_MESSAGE);
                break;
            }
            switch (command) {
                case CHANGE_DIRECTORY_COMMAND -> changeDirectory(argument, currentDirectory);
                case SHOW_DIRECTORY_COMMAND -> showDirectory(currentDirectory);
                default -> System.out.println(COMMAND_NOT_FOUND_MESSAGE);
            }
        }
    }

    private static void showDirectory(File directory) {
        File[] files = directory.listFiles();
        int fileCounter = 0;
        int dirCounter = 0;
        long fileTotalSize = 0;
        try {
            fileTotalSize = printAttribute(directory);
            fileTotalSize = printAttribute(directory.getParentFile());
            fileTotalSize = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (files != null) {
            for (File file : files) {
                try {
                    long size = printAttribute(file);
                    if (file.isFile()) {
                        fileCounter++;
                        fileTotalSize += size;
                    } else {
                        dirCounter++;
                    }

                } catch (IOException e) {
                    throw new RuntimeException(INPUT_ERROR_EXCEPTION, e);
                }
            }
        }
        long usableSpace = directory.getUsableSpace();

        System.out.printf("%15d File(s)%23s bytes%n", fileCounter, insertSeparator(fileTotalSize));
        System.out.printf("%15d Dir(s)%24s bytes free%n", dirCounter, insertSeparator(usableSpace));
    }

    private static long printAttribute(File file) throws IOException {
        Path path = file.toPath();
        Object creationTime = Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS);
        Instant dateTime = ((FileTime) creationTime).toInstant();
        LocalDateTime ldt = LocalDateTime.ofInstant(dateTime, ZoneId.systemDefault());
        String formattedDateTime = String.format("%02d/%02d/%4d  %02d:%02d",
                ldt.getDayOfMonth(), ldt.getMonthValue(), ldt.getYear(), ldt.getHour(), ldt.getMinute());
        String directoryFlag = file.isDirectory() ? "<DIR>" : "";
        long size = (long) Files.getAttribute(path, "size");
        String sizeString = file.isFile() ? insertSeparator(size) : "";
        String fileName;
        if (file.equals(currentDirectory)) {
            fileName = CURRENT_DIRECTORY;
        } else if (file.equals(currentDirectory.getParentFile())) {
            fileName = PARENT_DIRECTORY;
        } else {
            fileName = String.valueOf(path.getFileName());
        }
        System.out.printf("%-20s%-6s%20s %-30s%n", formattedDateTime, directoryFlag, sizeString, fileName);
        return size;
    }

    private static void changeDirectory(String argument, File directory) {
        if (EMPTY_STRING.equals(argument)) {
            System.out.println(SPECIFY_PATH_MESSAGE);
            return;
        }
        File file = new File(directory.getAbsolutePath() + File.separator + argument);
        if (file.exists() && file.isDirectory()) {
            try {
                file = file.getCanonicalFile();
                currentDirectory = file;
                System.out.println();
            } catch (IOException e) {
                throw new RuntimeException(INCORRECT_FILE_PATH_MESSAGE, e);
            }
        } else {
            System.out.println(INCORRECT_FILE_PATH_MESSAGE);
        }
    }

    private static String insertSeparator(long value) {
        String s = String.valueOf(value);
        StringBuilder builder = new StringBuilder(s);
        int currentPosition = builder.length() - GROUP_LENGTH;
        while (currentPosition > 0) {
            builder.insert(currentPosition, " ");
            currentPosition -= GROUP_LENGTH;
        }
        return builder.toString();
    }
}
