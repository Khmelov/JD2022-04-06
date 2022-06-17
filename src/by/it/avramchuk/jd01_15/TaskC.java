package by.it.avramchuk.jd01_15;

import by.it.avramchuk.jd01_14.Util;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String startPath = Util.getPath(TaskC.class);

        File startDir = new File(startPath);
        File currentDir = startDir;
        Scanner scanner = new Scanner(System.in);
        System.out.print(startDir+">");
        while (scanner.hasNext()){
            String userInput = scanner.nextLine();
            userInput = userInput.trim();
            if (userInput.equalsIgnoreCase("end")){
                break;
            }
            if (userInput.equalsIgnoreCase("dir")){
                if(currentDir.isDirectory()){
                    int countFiles=0;
                    int countDirs=2;
                    long bytes=0;
                    System.out.printf("%17s%8s%s\n", Util.getModifiedTime(currentDir),"<DIR>\t",".");
                    System.out.printf("%17s%8s%s\n", Util.getModifiedTime(currentDir.getParentFile()),"<DIR>\t","..");
                    File[] content = currentDir.listFiles();
                    assert content != null;
                    for (File file : content) {
                        if(file.isDirectory()){
                            System.out.printf("%17s%8s%s\n", Util.getModifiedTime(file),"<DIR>\t",file.getName());
                            countDirs++;
                        }else{
                            System.out.printf("%17s%8s%5d%25s\n",Util.getModifiedTime(file),"\t\t",file.length(),file.getName());
                            countFiles++;
                            bytes+=file.length();
                        }
                    }
                    System.out.println(countFiles+" файлов\t\t"+bytes+" байт");
                    System.out.println(countDirs+" папок\t"+currentDir.getFreeSpace()+" свободно");
                }
            }else {
                if (userInput.length() > 2) {
                    if (userInput.equalsIgnoreCase("cd ..")) {
                        currentDir = currentDir.getParentFile();
                    } else {
                        if (userInput.substring(0, 3).equalsIgnoreCase("cd ")) {
                            userInput = userInput.replaceAll("cd ", "");
                            String newPath = currentDir.getAbsolutePath() + File.separator + userInput;
                            File utilFile = new File(newPath);
                            if (utilFile.exists()) {
                                if (utilFile.isDirectory()) {
                                    currentDir = utilFile;
                                } else {
                                    System.out.println("не удается найти указанный путь");
                                }
                            } else {
                                System.out.println("не удается найти указанный путь");
                            }
                        } else {
                            System.out.println("неверная команда");
                        }
                    }
                }
            }
            System.out.print(currentDir+">");
        }
    }
}
