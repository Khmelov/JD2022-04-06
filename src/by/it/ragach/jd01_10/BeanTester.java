package by.it.ragach.jd01_10;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> structure = Bean.class;
        Constructor<Bean> constructor = structure.getConstructor();
        Object o = constructor.newInstance();

        Method[] methods = structure.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                String name = method.getName();
                System.out.println(name);
                System.out.println(method.invoke(o, annotation.a(),annotation.b()));

            }
        }

    }
}



