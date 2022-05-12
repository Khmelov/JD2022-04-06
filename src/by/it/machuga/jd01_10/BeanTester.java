package by.it.machuga.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getDeclaredConstructor();
        Bean bean = constructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                int a = annotation.a();
                int b = annotation.b();
                Object result;
                if (Modifier.isStatic(method.getModifiers())) {
                    result = method.invoke(null, a, b);
                } else {
                    result = method.invoke(bean, a, b);
                }
                System.out.printf("%s -> %s%n", method.getName(), result);
            }
        }
    }
}
