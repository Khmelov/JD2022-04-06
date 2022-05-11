package by.it.annazhegulovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.StringJoiner;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;                                //достали структурц класса Math

        Field[] declaredFields = mathClass.getDeclaredFields();         // достали поля метода Math (только Math, не Object )
        for (Field field : declaredFields) {                            // перебрали поля
            StringJoiner outFields = new StringJoiner(" ");     //собираем все поля с разделителем " "
            if (Modifier.isPublic(field.getModifiers())){               //проверили на Public
             addModifiersField(field, outFields);
                Type genericType = field.getGenericType();              //достали тип поля
                String typeName = genericType.getTypeName();
                outFields.add(typeName);
                String name = field.getName();                          //достали имя поля
                outFields.add(name);
                System.out.println(outFields);                          //ВЫВЕЛИ ВСЕ ПОЛЯ
        }
        }

        Method[] declaredMethods = mathClass.getDeclaredMethods();      // достали методы класса Math (только Math, не Object )
        for (Method method : declaredMethods) {                         // переберем все методы
            StringJoiner outPrint = new StringJoiner(" ");      //собираем все методы с разделителем " "
            if (Modifier.isPublic(method.getModifiers())) {             //проверили на Public

                addModifiersMetod(method, outPrint);

                Class<?> returnType = method.getReturnType();               //достали взвращаемый тип
                String simpleName = returnType.getSimpleName();             //записали в строку возвр.тип (double,float,int..)
                outPrint.add(simpleName);
                String name = method.getName();                             //достали имя метода (sin,cos..)
                StringJoiner paramMetods = new StringJoiner(",", "(", ")");//собрали имя метода+ параметры
                Class<?>[] parameterTypes = method.getParameterTypes();     // достали параметры метода (..)
                for (Class<?> type : parameterTypes) {                      // перебрали их и записали
                    paramMetods.add(type.getSimpleName());
                }
                outPrint.add(name + paramMetods);                           // добавили имя метода и параметры
                System.out.println(outPrint);                               //ВЫВЕЛИ ВСЕ МЕТОДЫ
            }
        }
    }

    private static void addModifiersField(Field field, StringJoiner outFields) {
        int modifiers = field.getModifiers();                      // достали модификатор полей(public,private,static...)
        if (Modifier.isPublic(modifiers)) {                            // из них выберем только public
            outFields.add("public");
        }
        if (Modifier.isStatic(modifiers)) {                             // из них выберем только static
            outFields.add("static");
        }
        if (Modifier.isFinal(modifiers)) {                             // из них выберем только final
            outFields.add("final");

        }
    }

    private static void addModifiersMetod(Method method, StringJoiner outPrint) {
        int modifiers = method.getModifiers();                      // достали модификатор метода (public,private,static...)
        if (Modifier.isPublic(modifiers)) {                            // из них выберем только public
            outPrint.add("public");
        }
        if (Modifier.isStatic(modifiers)) {                             // из них выберем только static
            outPrint.add("static");
        }
        if (Modifier.isFinal(modifiers)) {                             // из них выберем только final
            outPrint.add("final");

        }
    }
}


