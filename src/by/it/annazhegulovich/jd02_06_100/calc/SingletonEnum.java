package by.it.annazhegulovich.jd02_06_100.calc;

import by.it.annazhegulovich.jd01_14.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import static by.it.annazhegulovich.jd02_06_100.calc.constans.Patterns.RESULT_TXT;

public enum SingletonEnum implements Log{

    INSTANCE;

    private final String path = Util.getPath(SingletonEnum.class, RESULT_TXT);

    @Override
    public void messageToFile(String message) {


        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))){
            writer.println(message);

        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}