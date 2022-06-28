package by.it.smirnov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Object o = null;
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                if (o == null) o = beanClass.getDeclaredConstructor().newInstance();
                double result=0;
                int x = annotation.a();
                    try {
                        if (Modifier.isStatic(method.getModifiers())) result = (double) method.invoke(null, annotation.a(),annotation.b());
                        else result = (double) method.invoke(o, annotation.a(),annotation.b());
                        } catch (Throwable e) {
                        System.out.println(e.getCause());
                    }
                System.out.println(method.getName());
                System.out.println(result);

            }
        }
    }
}
