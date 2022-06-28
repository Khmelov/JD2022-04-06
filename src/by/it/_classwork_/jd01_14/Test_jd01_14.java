package by.it._classwork_.jd01_14;


import by.it.HomeWork;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_14 extends HomeWork {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        HomeWork run = run("");
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(dir(this.getClass()) + "dataTaskA.bin"))
                );
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                sb.append(i + " ");
                sum = sum + i;
                count++;
            }
            run.include(sb.toString().trim()); //проверка строки из 20 чисел
            run.include("avg=" + sum / count); //проверка вывода среднего арифметического

            Scanner scanner = new Scanner(new File(dir(this.getClass()) + "resultTaskA.txt"));
            //проверка соответсвия вывода и содержимого файла отчета resultTaskA.txt
            while (scanner.hasNext()) {
                run.include(scanner.nextLine());
            }
            scanner.close();
        }
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        HomeWork run = run("");
        run.include("words=157"); //слов должно быть 157
        run.include("marks=32");  //знаков должно быть 32 (исправлено 21.01.2018)
        StringBuilder sb = new StringBuilder();
        //читаем файл с числами
        Scanner scanner = new Scanner(new File(dir(this.getClass()) + "resultTaskB.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskB.txt
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        HomeWork run = run("");
        showDir(dir(this.getClass())+"..",run);
        Scanner scanner = new Scanner(new File(dir(this.getClass()) + "resultTaskC.txt"));
        //проверка соответствия вывода и содержимого файла отчета resultTaskC.txt
        scanner.nextLine(); //пропуск потенциально возможного dir:..
        while (scanner.hasNext()) {
            run.include(scanner.nextLine());
        }
        scanner.close();
    }

    private static void showDir(String path, HomeWork run) {
        File p = new File(path);
        String name = p.getName();
        if (p.isFile()) {
            run.include("file:" + name); //имя файла (должно быть с расширением)
        } else if (p.isDirectory()) {
            if (!name.equals(".") && !name.equals("..")) //fix
                run.include("dir:" + name); //имя каталога, .git - тоже каталог
            File[] paths = p.listFiles();
            if (paths != null)
                for (File iterator : paths) {
                    showDir(iterator.getAbsolutePath(),run);
                }
        }
    }

    static String dir(Class cl) {
        return System.getProperty("user.dir") + "/src/" +
                cl.getName().replace(cl.getSimpleName(), "").replace('.', '/');
    }


}
