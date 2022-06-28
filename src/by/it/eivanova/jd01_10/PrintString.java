package by.it.eivanova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        printNotStaticMethods(methods);
    }

    private static void printNotStaticMethods(Method[] methods) {
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                System.out.println(method.getName());
            }
        }
    }
}
