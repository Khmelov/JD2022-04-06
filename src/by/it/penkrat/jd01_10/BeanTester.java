package by.it.penkrat.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();


        for (Method method : methods) {
            Object o = null;

            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                if (Modifier.isStatic(method.getModifiers())) {

                    System.out.println(method.getName() + " " + method.invoke(null, param.a(), param.b()));
                } else {

                    o = beanClass.getDeclaredConstructor().newInstance();
                    System.out.println(method.getName() + " " + method.invoke(o, param.a(), param.b()));
                }

            }

        }

    }

}
