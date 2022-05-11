package by.it.avramchuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;

        Method[] methods = mathClass.getDeclaredMethods();

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())){
                String out = createOutString(method);
                System.out.println(out);
            }
        }

        Field[] fields = mathClass.getFields();

        for (Field field : fields) {
            System.out.println(field.getType()+" "+ field.getName());
        }
    }

    private static String createOutString (Method method) {
        StringBuilder out = new StringBuilder();
        extractModif(method, out);
        extractReturnType(method, out);
        out.append(method.getName());
        extractParamTypes(method, out);
        return out.toString();
    }

    private static void extractParamTypes (Method method, StringBuilder out) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        out.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            out.append(parameterTypes[i].getName());
            if(i!=(parameterTypes.length-1)){
                out.append(',');
            }
        }
        out.append(')');
    }

    private static void extractReturnType(Method method, StringBuilder out) {
        Class<?> returnType = method.getReturnType();
        out.append(returnType).append(" ");
    }

    private static void extractModif (Method method, StringBuilder out) {
        int modifiers = method.getModifiers();

        if (Modifier.isPublic(modifiers)) {
            out.append("public").append(" ");
        }
        if (Modifier.isStatic(modifiers)) {
            out.append("static").append(" ");
        }
    }
}
