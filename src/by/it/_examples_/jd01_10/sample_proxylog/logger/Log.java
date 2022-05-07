package by.it._examples_.jd01_10.sample_proxylog.logger;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String text();

    Level level() default Level.INFO;

    enum Level {
        ERROR(31), DEBUG(32), INFO(33), MESSAGES(34);

        public final int color;

        Level(int color) {
            this.color = color;
        }
    }
}
