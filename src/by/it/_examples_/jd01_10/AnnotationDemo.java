package by.it._examples_.jd01_10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationDemo {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BaseAction {
        int level();

        String sqlRequest();
    }

    @BaseAction(
            level = 2,
            sqlRequest = "SELECT * FROM PhoneBook"
    )
    public static class Base {
        void doAction() {
            Class<Base> f = Base.class;
            BaseAction a = f.getAnnotation(BaseAction.class);
            System.out.println("level=" + a.level());
            System.out.println("sqlRequest=" + a.sqlRequest());
        }
    }

    public static void main(String[] args) {
        new Base().doAction();
    }
}
