package by.it._examples_.jd01_15;

import java.io.IOException;
import java.nio.file.*;

public class FilesDemo {
    public static void main(String[] args) throws IOException, IOException {

        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_15/";
        String fileInTxt = src + "in.txt";
        String fileBak = src + "in.bak";
        String fileMove = src + "in.move";
        //получим пути
        Path path = Paths.get(fileInTxt);
        Path pathForCopy = Paths.get(fileBak);
        Path pathForMove = Paths.get(fileMove);
        //прочитаем свойства файла
        System.out.printf("Readablez %b, Writable: %b, Executable: %b\n",
                Files.isReadable(path), Files.isWritable(path),
                Files.isExecutable(path));
        //и аттрибуты
        System.out.printf("Creation time: %s\nLast modified time: %s\nSize: %s\nDir: %s\n",
                Files.getAttribute(path, "creationTime", LinkOption.NOFOLLOW_LINKS),
                Files.getAttribute(path, "lastModifiedTime", LinkOption.NOFOLLOW_LINKS),
                Files.getAttribute(path, "size"),
                Files.getAttribute(path, "isDirectory")
        );
        //пример копирования
        Files.copy(path, pathForCopy, StandardCopyOption.REPLACE_EXISTING);
        //переноса
        Files.move(pathForCopy, pathForMove, StandardCopyOption.REPLACE_EXISTING);
        //удаления
        Files.delete(pathForMove);
    }
}
