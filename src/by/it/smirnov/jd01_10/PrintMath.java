package by.it.smirnov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();


    }
    
}
