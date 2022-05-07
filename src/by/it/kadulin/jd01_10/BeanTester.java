package by.it.kadulin.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<?> structure = Bean.class;
        Constructor<?> constructor = structure.getDeclaredConstructor();
        Object o = constructor.newInstance();
        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                System.out.println(method.getName() + "=" + method.invoke(o,a,b));
            }
        }
    }
}
