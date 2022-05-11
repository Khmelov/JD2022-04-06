package by.it.kameisha.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        printPublicMethods(mathClass);
        printPublicFields(mathClass);
    }

    private static void printPublicFields(Class<Math> mathClass) {
        Field[] mathFields = mathClass.getDeclaredFields();
        for (Field field : mathFields) {
            if (Modifier.isPublic(field.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                getModifier(field, line);
                line.add(field.getType().getSimpleName());
                line.add(field.getName());
                System.out.println(line);
            }
        }
    }

    private static void printPublicMethods(Class<Math> mathClass) {
        Method[] mathMethods = mathClass.getDeclaredMethods();
        for (Method method : mathMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                getModifier(method, line);
                line.add(method.getReturnType().getSimpleName());
                String methodNAme = method.getName();
                Class<?>[] parametrTypes = method.getParameterTypes();
                StringJoiner parametrs = new StringJoiner(",", "(", ")");
                for (Class<?> parametrType : parametrTypes) {
                    parametrs.add(parametrType.getSimpleName());
                }
                line.add(methodNAme + parametrs);
                System.out.println(line);
            }
        }
    }

    private static void getModifier(Method method, StringJoiner line) {
        if (Modifier.isPublic(method.getModifiers())) {
            line.add("public");
        }
        if (Modifier.isStatic(method.getModifiers())) {
            line.add("static");
        }
        if (Modifier.isProtected(method.getModifiers())) {
            line.add("protected");
        }
        if (Modifier.isPrivate(method.getModifiers())) {
            line.add("private");
        }
    }

    private static void getModifier(Field field, StringJoiner line) {
        if (Modifier.isPublic(field.getModifiers())) {
            line.add("public");
        }
        if (Modifier.isStatic(field.getModifiers())) {
            line.add("static");
        }
        if (Modifier.isProtected(field.getModifiers())) {
            line.add("protected");
        }
        if (Modifier.isPrivate(field.getModifiers())) {
            line.add("private");
        }
    }
}
