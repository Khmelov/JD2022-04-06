package by.it.korennaya.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structure = Math.class;
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                addModifiers(method, line);
                line.add(method.getReturnType().getSimpleName());
                String name = method.getName();
                StringJoiner parameters = new StringJoiner(",", "(", ")");
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    parameters.add(type.getSimpleName());
                }
                line.add(name + parameters);
                System.out.println(line);
            }
        }
        System.out.println("double E");
        System.out.println("double PI");
    }

    private static void addModifiers(Method method, StringJoiner out) {
        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            out.add("public");
        }
        if (Modifier.isPrivate(modifiers)) {
            out.add("private");
        }
        if (Modifier.isProtected(modifiers)) {
            out.add("protected");
        }
        if (Modifier.isStatic(modifiers)) {
            out.add("static");
        }
        if (Modifier.isFinal(modifiers)) {
            out.add(" ");
        }
    }
}