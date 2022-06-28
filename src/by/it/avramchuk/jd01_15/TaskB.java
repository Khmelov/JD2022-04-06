package by.it.avramchuk.jd01_15;
/**
 * JavaDoc comment и даже на русском
 */
import by.it.avramchuk.jd01_14.Util;
import java.io.*;
public class TaskB {
    //удалить все комменты
       public static void main(String[] args) {
        String javaFile = Util.getPath(TaskB.class, "TaskB.java");
        StringBuilder withoutComments = new StringBuilder();
        readFile(withoutComments, javaFile);
        System.out.print(withoutComments);
        String txtFile = Util.getPath(TaskB.class, "TaskB.txt");
        printToFile(withoutComments, txtFile);
    }

    private static void printToFile(StringBuilder sb, String fileName) {
           try(PrintWriter out = new PrintWriter(fileName)){
               out.print(sb);
           } catch (FileNotFoundException e) {
               throw new RuntimeException("error io:"+ e);
           }
    }
/*
многострочный
 */
    private static void readFile(StringBuilder sb, String fileName) {
           try(RandomAccessFile sourceFile = new RandomAccessFile(fileName, "r")){
               long length = sourceFile.length();
               for (long pos = 0; pos < length; pos++) {
                   sourceFile.seek(pos);
                   char ch =(char) sourceFile.read();
                   /*этот блок удаляет многострочный комментарий
                   */
                   if ((String.valueOf(ch)).equals("/")){
                       char nextCh =(char) sourceFile.read();
                       if ((String.valueOf(nextCh)).equals("*")){
                          do {
                              nextCh = (char) sourceFile.read();
                          }while (!((String.valueOf(nextCh)).equals("/")));
                          pos = sourceFile.getFilePointer()-1;
                       } else {
                           //этот блок удаляет однострочный комментарий
                           if ((String.valueOf(nextCh)).equals("/")){
                               do {
                                   nextCh = (char) sourceFile.read();
                               }while (!((String.valueOf(nextCh)).equals("\n")));
                               pos = sourceFile.getFilePointer()-2;
                           } else {
                               sb.append(ch);
                           }
                       }
                   }else {sb.append(ch);}
               }
           } catch (IOException e) {
               throw new RuntimeException("error io: "+ e);
           }
    }
}
