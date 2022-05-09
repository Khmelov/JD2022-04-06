package by.it.marchenko.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.StringJoiner;

public class BeanTester {
    public static final String WORD_SEPARATOR = " ";

    public static void main(String[] args) throws Exception {
        Object createdObject = Bean.class.getConstructor().newInstance();
        Method[] methods = Bean.class.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Param) {
                    int a = ((Param) annotation).a();
                    int b = ((Param) annotation).b();
                    StringJoiner tempLine = new StringJoiner(WORD_SEPARATOR);
                    System.out.println(annotation);
                    String result = switch (method.getParameterCount()) {
                        case 0 -> (method.invoke(createdObject)).toString();
                        case 1 -> (method.invoke(createdObject, a)).toString();
                        default -> (method.invoke(createdObject, a, b)).toString();
                    };
                    tempLine.add(method.getName()).add(result);
                    System.out.println(tempLine);
                }
            }
        }
    }
}