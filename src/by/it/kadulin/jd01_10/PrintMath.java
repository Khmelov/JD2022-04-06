package by.it.kadulin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structure = Math.class;
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            getStringModifies(sb, method.getModifiers());
            Class<?> returnType = method.getReturnType();
            sb.append(returnType.getSimpleName()).append(" ");
            sb.append(method.getName());
            getParameters(method, sb);
            System.out.println(sb.toString());
        }
        Field[] fields = structure.getFields();
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder();
            getStringModifies(sb, field.getModifiers());
            sb.append(field.getType()).append(" ").append(field.getName());
            System.out.println(sb.toString());
        }

    }

    private static void getStringModifies(StringBuilder sb, int modifiers2) {
        int modifiers = modifiers2;
        if (Modifier.isPublic(modifiers)) {
            if (Modifier.isStatic(modifiers)) {
                sb.append("public").append(" ");
                sb.append("static").append(" ");
            }
        }
    }

    private static void getParameters(Method method, StringBuilder sb) {
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length > 0) {
            for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i].getSimpleName());
                if (i != parameterTypes.length - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append(")");
    }
}
