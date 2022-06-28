package by.it.marchenko.jd01_10;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    int a() default 2;

    int b() default 5;
}

