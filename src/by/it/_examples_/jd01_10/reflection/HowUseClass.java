package by.it._examples_.jd01_10.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HowUseClass {
    public static void main(String[] args) throws Exception {
        Class<?> c = String.class;
        //далее я не знаю что это за класс, но могу получить его методы
        for (Method method : c.getDeclaredMethods()) {
            String name = method.getName();
            Class<?>[] types = method.getParameterTypes();
            String returnType = method.getReturnType().getSimpleName();
            System.out.printf("%s %s(%s)\n", returnType, name, Arrays.toString(types));
        }
        //или интерфейсы
        for (Class<?> inter : c.getInterfaces()) {
            System.out.println(inter);
        }
        //или создать экземпляр
        Constructor<?> constructor = c.getConstructor(String.class);
        Object o = constructor.newInstance("Hi");
        System.out.println(o);
        //или найти и вызвать нужный метод
        Method method = c.getMethod("length");
        System.out.println(method.invoke(o));
        //и т.д. Наберите в следующей строчке: c и точку - это и будет Reflection API
        c.getCanonicalName();
    }

}
