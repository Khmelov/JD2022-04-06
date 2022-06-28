package by.it.arsenihlaz.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;

        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Constructor<Bean> constructor = beanClass.getDeclaredConstructor();
                Object o = constructor.newInstance();
                int a = method.getAnnotation(Param.class).a();
                int b = method.getAnnotation(Param.class).b();
                System.out.println(method.invoke(o, a, b));
                System.out.println(method.getName());
            }
        }
    }
}
