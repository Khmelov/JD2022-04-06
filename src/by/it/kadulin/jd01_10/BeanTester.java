package by.it.kadulin.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> structure = Bean.class;
        Constructor<?> constructor = structure.getDeclaredConstructor();
        Object o = constructor.newInstance();
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Parameter[] parameters = method.getParameters();
                Param annotation = method.getAnnotation(Param.class);
                switch (parameters.length) {
                    case 0 -> System.out.println(method.getName() + "=" + method.invoke(o));
                    case 1 -> System.out.println(method.getName() + "=" + method.invoke(o, annotation.a()));
                    case 2 -> System.out.println(method.getName() + "=" + method.invoke(o, annotation.a(), annotation.b()));
                }
            }
        }
    }
}
