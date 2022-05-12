package by.it.avramchuk.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<Bean> beanClass = Bean.class;
        Method[] allMethods = beanClass.getDeclaredMethods();
        Constructor<?> constructor = beanClass.getConstructor();
        Object o = constructor.newInstance();



        for (Method method : allMethods) {
            if (method.isAnnotationPresent(Param.class)){

                    Param param = method.getAnnotation(Param.class);
                    System.out.print(method.getName()+" ");
                    System.out.println(method.invoke(o, param.a(), param.b()));

                }
            }
        }
    }

