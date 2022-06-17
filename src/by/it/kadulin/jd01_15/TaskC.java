package by.it.kadulin.jd01_15;

import by.it.kadulin.jd01_14.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TaskC {
    public static void main(String[] args) {

        StringBuilder currentPathForConsole = new StringBuilder();
        Path currentPath = Path.of(Util.getPath(TaskC.class, ""));
        currentPathForConsole.append(currentPath.toString());
        addLastChar(currentPathForConsole);
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print(currentPathForConsole);
                final String line = console.readLine();
                final String[] splittedLine = line.split(" ");
                if (line.equals("cd/")) {
                    currentPath = currentPath.getRoot();
                    currentPathForConsole.replace(0, currentPathForConsole.length(), "");
                    currentPathForConsole.append(currentPath);
                    addLastChar(currentPathForConsole);
                }
                else if (line.equals("cd")) {
                    System.out.println(currentPathForConsole);
                }
                else if (line.equals("cd..")) {
                    Path pathForCheck = currentPath.getRoot();
                    if (!currentPath.equals(pathForCheck)) {
                        currentPath = currentPath.getParent();
                        currentPathForConsole.replace(0, currentPathForConsole.length(), "");
                        currentPathForConsole.append(currentPath);
                        addLastChar(currentPathForConsole);
                    }
                }
                else if (splittedLine.length == 2) {
                    File file = new File(currentPath + File.separator + splittedLine[1]);
                    if (!file.exists()) {
                        System.out.println("Системе не удаётся найти указанный путь.");
                    }
                    else {
                        currentPath = Path.of(String.valueOf(file));
                        currentPathForConsole.replace(0, currentPathForConsole.length(), "");
                        currentPathForConsole.append(currentPath);
                        addLastChar(currentPathForConsole);
                    }
                }
                else if (line.equals("dir")) {
                    File currentFile = new File(currentPath.toString());
                    final File[] files = currentFile.listFiles();
                    int countOfFiles = 0;
                    int countOfFilesSize = 0;
                    int countOfDirs = 0;
                    for (File file : files) {
                        final long l = file.lastModified();
                        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd.MM.yyyy  hh:mm");
                        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
                        String typeOfFile = "";
                        long sizeOfFile = 0;
                        if (file.isDirectory()) {
                            countOfDirs++;
                            typeOfFile = "<DIR>";
                            System.out.printf("%17s%9s%20s%35s%n", dtf1.format(date), typeOfFile, "", file.getName());
                        }
                        else if (file.isFile()) {
                            countOfFiles++;
                            countOfFilesSize += file.length();
                            sizeOfFile = file.length();
                            System.out.printf("%17s%9s%20d%35s%n", dtf1.format(date), typeOfFile, sizeOfFile, file.getName());
                        }

                    }

                    System.out.printf("%5d%9s%20d%s%n", countOfFiles,"file(s)", countOfFilesSize, " bytes");
                    System.out.printf("%5d%9s%20d%s%n", countOfDirs, "dirs", currentFile.getFreeSpace(), " bytes free");
                }
                else if (line.equals("end")) {
                    break;
                }
            }

//            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(currentPath);
    }

    private static void addLastChar(StringBuilder currentPath) {
        currentPath.append(">");
    }
}
