package by.it.penkrat.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> structure = Math.class;
        printMethod(structure);
        printFields(structure);

    }

    private static void printFields(Class<Math> structure) {
        Field[] fields = structure.getFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                addFieldModifiers(field, line);

                Class<?> type = field.getType();
                line.add(type.getTypeName());

                String name = field.getName();
                line.add(name);

                System.out.println(line);
            }
        }
    }

    private static void printMethod(Class<Math> structure) {
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                addModifiers(method, line);

                line.add(method.getReturnType().getSimpleName());

                String name = method.getName();
                StringJoiner param = new StringJoiner(",", "(", ")");
                Class<?>[] type = method.getParameterTypes();
                for (Class<?> types : type) {
                    param.add(types.getSimpleName());
                }
                line.add(name + param);
                System.out.println(line);

            }

        }
    }

    private static void addModifiers(Method method, StringJoiner sb) {

        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            sb.add("public");
        }
        if (Modifier.isPrivate(modifiers)) {
            sb.add("private");
        }
        if (Modifier.isProtected(modifiers)) {
            sb.add("protected");
        }
        if (Modifier.isStatic(modifiers)) {
            sb.add("static");
        }
    }

    private static void addFieldModifiers(Field field, StringJoiner stringJoiner) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)){
            stringJoiner.add("public");
        }
        if (Modifier.isPrivate(modifiers)){
            stringJoiner.add("private");
        }
        if (Modifier.isStatic(modifiers)){
            stringJoiner.add("static");
        }
        if (Modifier.isFinal(modifiers)){
            stringJoiner.add("final");
        }
    }
}


