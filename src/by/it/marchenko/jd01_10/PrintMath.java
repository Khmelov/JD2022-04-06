package by.it.marchenko.jd01_10;

import java.lang.reflect.*;
import java.util.StringJoiner;

public class PrintMath {
    public static final String WORD_SEPARATOR = " ";

    public static void main(String[] args) {
        Class<?> structureMath = Math.class;
        Field[] fields = structureMath.getDeclaredFields();
        Method[] methods = structureMath.getDeclaredMethods();
        printPublic(fields);
        printPublic(methods);
    }

    private static void printPublic(Field[] fields) {
        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (Modifier.isPublic(modifier)) {
                StringJoiner tempLine = new StringJoiner(WORD_SEPARATOR);
                tempLine.add(getModifiersName(modifier)).
                        add(field.getType().getSimpleName()).
                        add(field.getName());
                System.out.println(tempLine);
            }
        }
    }

    private static void printPublic(Method[] methods) {
        for (Method method : methods) {
            int modifier = method.getModifiers();
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner tempLine = new StringJoiner(WORD_SEPARATOR);
                tempLine.add(getModifiersName(modifier)).
                        add(method.getReturnType().getSimpleName()).
                        add(getMethodParameters(method));
                System.out.println(tempLine);
            }
        }
    }

    private static String getMethodParameters(Method method) {
        final String ARGUMENT_SEPARATOR = ",";
        final String ARGUMENTS_PREFIX = "(";
        final String ARGUMENT_SUFFIX = ")";
        StringJoiner tempLine = new StringJoiner(ARGUMENT_SEPARATOR, ARGUMENTS_PREFIX, ARGUMENT_SUFFIX);
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            tempLine.add(parameterType.getName());
        }
        return method.getName().concat(tempLine.toString());
    }

    private static String getModifiersName(int modifier) {
        final String PUBLIC = "public";
        final String STATIC = "static";
        final String FINAL = "final";
        StringJoiner tempLine = new StringJoiner(WORD_SEPARATOR);
        if (Modifier.isPublic(modifier)) {
            tempLine.add(PUBLIC);
        }
        if (Modifier.isStatic(modifier)) {
            tempLine.add(STATIC);
        }
        if (Modifier.isFinal(modifier)) {
            tempLine.add(FINAL);
        }
        return tempLine.toString();
    }
}
