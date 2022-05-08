package by.it.arsenihlaz.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner methodsLine = new StringJoiner(" ");
                addModifiers(method, methodsLine);
                addReturnType(method, methodsLine);
                addNameAndParameters(method, methodsLine);
                System.out.println(methodsLine);
            }
        }
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) ==Modifier.PUBLIC) {
                StringJoiner fieldsLine = new StringJoiner(" ");
                Class<?> returnType = field.getType();
                String nameReturnType = returnType.getSimpleName();
                fieldsLine.add(nameReturnType);
                String name = field.getName();
                fieldsLine.add(name);
                System.out.println(fieldsLine);
            }
        }
    }

    private static void addNameAndParameters(Method method, StringJoiner methodsLine) {
        String nameMethod = method.getName();
        StringJoiner parameters = new StringJoiner(",", "(", ")");
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            parameters.add(parameterType.getSimpleName());
        }
        methodsLine.add(nameMethod + parameters);
    }

    private static void addReturnType(Method method, StringJoiner methodsLine) {
        Class<?> returnType = method.getReturnType();
        String nameReturnType = returnType.getSimpleName();
        methodsLine.add(nameReturnType);
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
    }
}
