package by.it._examples_.jd01_14;

public class Utils {
    public static String getFilePath(String name) {
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_14/";
        // здесь "/" - для  всех систем подходящий разделитель, но лучше File.separator использовать.
        // можно так например (need Java 9+):
        // String src = System.getProperty("user.dir")
        // + File.separator
        // + Utils.class.getPackageName().replace(".", File.separator)
        // + File.separator;
        return src + name;
    }

}
