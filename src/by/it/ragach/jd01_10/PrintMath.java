package by.it.ragach.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structure = Math.class;
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                StringJoiner out = new StringJoiner(" ");
                addModifiers(method, out);
                out.add(method.getReturnType().getSimpleName());
                String name = method.getName();
                StringJoiner parameters = new StringJoiner(",", "(", ")");
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    parameters.add(type.getSimpleName());

                }

            out.add(name + parameters);
            System.out.println(out);
          }
        }

        Field[] fields = structure.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                StringJoiner line = new StringJoiner(" ");
                fieldModifiers(field, line);
                line.add(field.getType().getSimpleName());
                line.add(field.getName());
                System.out.println(line);

            }
        }
        
    }

    private static void fieldModifiers(Field field, StringJoiner line) {
        int modifiers = field.getModifiers();
        if (Modifier.isPublic(modifiers)){
            line.add("public");
        }
        if (Modifier.isPrivate(modifiers)){
            line.add("private");
        }
        if (Modifier.isProtected(modifiers)){
            line.add("protected");
        }
        if (Modifier.isStatic(modifiers)){
            line.add("static");
        }
    }

    private static void addModifiers(Method method, StringJoiner out) {
        int modifiers = method.getModifiers();

        if (Modifier.isPublic(modifiers)){
            out.add("public");
        }
        if (Modifier.isPrivate(modifiers)){
            out.add("private");
        }
        if (Modifier.isProtected(modifiers)){
            out.add("protected");
        }
        if (Modifier.isStatic(modifiers)){
            out.add("static");
        }
    }
}
