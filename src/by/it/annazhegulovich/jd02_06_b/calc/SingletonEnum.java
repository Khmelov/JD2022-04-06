package by.it.annazhegulovich.jd02_06_b.calc;

import by.it.annazhegulovich.jd02_06_b.calc.constans.Patterns;

public enum SingletonEnum {
    INSTANCE;

   public String getRESULT_TXT() {
        return Patterns.RESULT_TXT;
    }
}
