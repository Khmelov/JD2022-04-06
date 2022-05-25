package by.it._tasks_.jd01_15;


import by.it.HomeWork;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_15 extends HomeWork {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        HomeWork run = run("");
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        try (BufferedReader inp = new BufferedReader(
                (new FileReader(dir(this.getClass()) + "matrix.txt"))
        );
        ) {
            String line;
            int count = 0;
            while ((line = inp.readLine()) != null) {
                assertEquals("Ожидается длина строк в 16 символов", 16, line.length());
                assertEquals("Ожидается 4 числа, разделенных пробелом", 4, line.trim().split("\\s+").length);
                run.include(line);
                count++;
            }
            assertEquals("Ожидается 6 строк", 6, count);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        run("");
        String s1 = getText("TaskB.txt").trim();
        String s2 = s1.replaceAll("(?s)/\\*.*?\\*/", "(это было удалено тестом)");
        String s3 = s1.replaceAll("//[^\\n]*+", "(это было удалено тестом)\\\n");
        assertTrue("Удалены не все многострочные комментарии", s1.equals(s2));
        assertTrue("Удалены не все однострочные комментарии", s1.equals(s3));

        String s0 = getText("TaskB.java").trim();
        s0 = s0.replaceAll("(?s)/\\*.*?\\*/", "");
        s0 = s0.replaceAll("//[^\\n]*+", "");
        char[] ch0 = s0.replaceAll("\r", "").toCharArray();
        char[] ch1 = s1.replaceAll("\r", "").toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] == ch0[i])
                System.out.print(ch1[i]);
            else
                fail("expected <<" + ch1[i] + ">>, actual <<" + ch0[i] + ">>");
            System.out.flush();
        }
    }


    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        run("dir\n" +
                "end\n").include("TaskC.java")
                .include("Test_jd01_15.java");
        run("cd ..\n" +
                "cd ..\n" +
                "dir\n" +
                "cd _tasks_\n" +
                "cd jd01_15\n" +
                "dir\n" +
                "end\n")
                .include("_tasks_")
                .include("Test_jd01_15.java");
    }

    private String getText(String fn) throws Exception {
        Scanner scanner = new Scanner(new File(dir(this.getClass()) + fn));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNext()) sb.append(scanner.nextLine() + "\n");
        scanner.close();
        return sb.toString();
    }


    private static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" + cl.getName().replace(cl.getSimpleName(), "").replace('.', '/');
    }



}