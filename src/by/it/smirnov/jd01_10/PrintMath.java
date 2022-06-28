package by.it.smirnov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            if(Modifier.isPublic(field.getModifiers())) System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }
        for (Method method : methods) {
            StringJoiner out = new StringJoiner(" ");
            if (Modifier.isPublic(method.getModifiers())) {
                out.add("public");
                if (Modifier.isStatic(method.getModifiers())) out.add("static");
                out.add(method.getReturnType().getSimpleName());
                String name = method.getName();
                StringJoiner param = new StringJoiner(",", "(", ")");
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    param.add(type.getTypeName());
                }
                out.add(name + param);
                System.out.println(out);
            }
        }
    }
}
