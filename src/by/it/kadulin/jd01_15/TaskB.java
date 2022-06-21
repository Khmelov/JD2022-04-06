package by.it.kadulin.jd01_15;

import by.it.kadulin.jd01_14.Util;

import java.io.*;

/**
 * blabla
 * blablaggg
 * blablabla
 */

public class TaskB {
    public static void main(String[] args) {
        String fileName = Util.getPath(TaskB.class, "TaskB.java");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            /*
            read chars
             */
            while (reader.ready()) {
                // boolean is comment
                boolean isComment = false;
                // int like char
                final int read = reader.read();
                int nextSymbol = 0;
                if ((char) read == '/') {
                    nextSymbol = reader.read();
                    if (nextSymbol == '/') {
                        isComment = true;
                        while (true) {
                            if (reader.read() == '\n') {
                                sb.append("\r");
                                break;
                            }
                        }
                    }
                    else if (nextSymbol == '*') {
                        while (true) {
                            if (reader.read() == '*') {
                                isComment = true;
                                if (reader.read() == '/') {
                                    break;
                                }
                            }
                        }
                    }

                }
                if (!isComment) {
                    sb.append((char) read);
                    if (nextSymbol != 0) {
                        sb.append((char) nextSymbol);
                    }

                }


            }
            /*
            catch exceptions
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
        String targetResultFileName = Util.getPath(TaskB.class, "TaskB.txt");
        try (final BufferedWriter writer = new BufferedWriter(new FileWriter(targetResultFileName))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
