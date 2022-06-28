package by.it.marchenko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> stringStructure = String.class;
        Method[] methods = stringStructure.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                System.out.println(method.getName());
            }
        }
    }
}
