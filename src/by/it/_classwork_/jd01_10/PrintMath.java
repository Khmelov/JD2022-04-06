package by.it._classwork_.jd01_10;

import java.lang.reflect.*;
import java.util.StringJoiner;

public class PrintMath {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Class<?> structure = Math.class;
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringJoiner line = new StringJoiner(SPACE);
                line.add(addModifiers(method));
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

        for (Field field : structure.getFields()) {
            String s = addModifiers(field);
            System.out.println(s+" "+field.getName());
        }
    }

    private static String addModifiers(Executable executable) {
        return addModifiers(executable.getModifiers());
    }

    private static String addModifiers(Field field) {
        return addModifiers(field.getModifiers());
    }

    private static String addModifiers(int modifiers) {
        StringJoiner out = new StringJoiner(SPACE);
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
        return out.toString();
    }
}
