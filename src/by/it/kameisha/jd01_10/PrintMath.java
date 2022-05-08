package by.it.kameisha.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] mathMethods = mathClass.getDeclaredMethods();
        Field[] mathFields = mathClass.getDeclaredFields();
        StringBuilder line = new StringBuilder("");
        for (Method method : mathMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                line.append("public");
                if (Modifier.isStatic(method.getModifiers())) {
                    line.append(" ").append("static");
                }
                line.append(" ").append(method.getReturnType().getSimpleName());
                line.append(" ").append(method.getName());
                Class<?>[] parametrTypes = method.getParameterTypes();
                line.append("(");
                String split = "";
                for (Class<?> parametrType : parametrTypes) {
                    line.append(split).append(parametrType.getSimpleName());
                    split = ",";
                }
                line.append(")");
                System.out.println(line);
                line = new StringBuilder("");
            }
        }
        System.out.println(line);
    }
}
