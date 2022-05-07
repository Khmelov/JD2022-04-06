package by.it._examples_.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class AnnotationDemo2 {
    //цель - метод
    @Target(value = ElementType.METHOD)
    @Retention(value = RetentionPolicy.RUNTIME)
    @interface StartObject {
    }

    //цель - метод
    @Target(value = ElementType.METHOD)
    @Retention(value = RetentionPolicy.RUNTIME)
    @interface StopObject {
    }

    //цель - метод
    @Target(value = ElementType.TYPE)
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface ControlledObject {
        String name();

    }

    //===============================================================
    //аннотируемый класс
    @SuppressWarnings("unused")
    @ControlledObject(name = "biscuits")
    public static class Cookies {

        @StartObject
        public void createCookie() {
            //бизнес логика
        }

        @StopObject
        public void stopCookie() {
            //бизнес логика
        }
    }


    //метод, проверяющий наличие аннотаций
    private void AnnotationReact() throws ClassNotFoundException {
        Class<?> cl = Class.forName("by.it._examples_.jd01_10.AnnotationDemo2$Cookies"); //загружаем класс
        //был аннотирован класс или нет
        if (!cl.isAnnotationPresent(ControlledObject.class)) {
            System.err.println("no annotation");
        } else {
            System.out.println("class annotated ; name  -  " + cl.getAnnotation(ControlledObject.class));
        }
        //теперь проверим аннотированы ли методы
        boolean hasStart = false;
        boolean hasStop = false;
        Method[] method = cl.getMethods();
        for (Method md : method) {
            if (md.isAnnotationPresent(StartObject.class)) {
                hasStart = true;
            }
            if (md.isAnnotationPresent(StopObject.class)) {
                hasStop = true;
            }
            if (hasStart && hasStop) {
                break;
            }
        }
        System.out.println("Start annotation  - " + hasStart + ";  Stop annotation  - " + hasStop);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AnnotationDemo2 instance = new AnnotationDemo2();
        instance.AnnotationReact();
    }

}
