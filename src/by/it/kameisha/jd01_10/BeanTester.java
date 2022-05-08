package by.it.kameisha.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Object object = beanClass.newInstance();
                Param param = method.getAnnotation(Param.class);
                System.out.println(param.a()+" "+param.b());
                System.out.println(method.invoke(object,param.a(),param.b()));
            }

        }
    }
}

