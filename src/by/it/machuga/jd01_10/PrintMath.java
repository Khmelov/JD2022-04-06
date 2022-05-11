package by.it.machuga.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                printMethodInfo(method);
            }
        }
        Field[] declaredFields = mathClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            StringJoiner stringJoiner = new StringJoiner(Constants.SPACE);
            if (Modifier.isPublic(declaredField.getModifiers())) {
                printFieldInfo(declaredField, stringJoiner);
            }
        }
    }

    private static void printFieldInfo(Field declaredField, StringJoiner stringJoiner) {
        String typeName = declaredField.getType().getSimpleName();
        stringJoiner.add(typeName);
        String name = declaredField.getName();
        stringJoiner.add(name);
        System.out.println(stringJoiner);
    }

    private static void printMethodInfo(Method method) {
        StringJoiner stringJoiner = new StringJoiner(Constants.SPACE);
        int modifiers = method.getModifiers();
        addModifiers(stringJoiner, modifiers);
        addReturnType(method, stringJoiner);
        addMethodNameWithParameter(method, stringJoiner);
        System.out.println(stringJoiner);
    }

    private static void addMethodNameWithParameter(Method method, StringJoiner stringJoiner) {
        String methodName = method.getName();
        StringJoiner parameters = new StringJoiner(Constants.COMMA, Constants.LEFT_BRACKET, Constants.RIGHT_BRACKET);
        Class<?>[] types = method.getParameterTypes();
        for (Class<?> type : types) {
            parameters.add(type.getSimpleName());
        }
        stringJoiner.add(methodName + parameters);
    }

    private static void addReturnType(Method method, StringJoiner stringJoiner) {
        Class<?> returnType = method.getReturnType();
        String simpleName = returnType.getSimpleName();
        stringJoiner.add(simpleName);
    }

    private static void addModifiers(StringJoiner stringJoiner, int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            stringJoiner.add(Constants.PUBLIC);
        }
        if (Modifier.isPrivate(modifiers)) {
            stringJoiner.add(Constants.PRIVATE);
        }
        if (Modifier.isProtected(modifiers)) {
            stringJoiner.add(Constants.PROTECTED);
        }
        if (Modifier.isStatic(modifiers)) {
            stringJoiner.add(Constants.STATIC);
        }
    }
}
