package by.it.annazhegulovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.StringJoiner;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methodsString = stringClass.getDeclaredMethods();
        for (Method method : methodsString) {
            StringJoiner metodS = new StringJoiner("");
            if (!Modifier.isStatic(method.getModifiers())) {
                metodS.add(method.getName());
            } else {
                continue;
            }
            System.out.println(metodS);
        }
    }
}
