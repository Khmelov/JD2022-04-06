package by.it.annazhegulovich.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> structureBean = Bean.class;                                       // достали структуру класса Bean
        Constructor<?> beanConstructor = structureBean.getConstructor();
        Object o = beanConstructor.newInstance();                                    //создали экземпляр класса Bean

        Method[] methodsBean = structureBean.getMethods();                          // достали массив методов
        String name;
        for (Method method : methodsBean) {                                           // перебрали методы
            if (method.isAnnotationPresent(Param.class)) {                           // если метод + аннотация @Param
                Param ann = method.getDeclaredAnnotation(Param.class);              // достали аннотацию
                name = method.getName();
                System.out.println(name + ", " + (method.invoke(o, ann.a(), ann.b()))); //вывод - имя+вызвали метод из экземпляра с парам.
            }
        }
    }
}



