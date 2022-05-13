package by.it.avramchuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if  (!(Modifier.isStatic(method.getModifiers()))){

                System.out.println(method.getName());
            }
        }
    }
}
