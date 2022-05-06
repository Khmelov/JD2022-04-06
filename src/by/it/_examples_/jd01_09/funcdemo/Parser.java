package by.it._examples_.jd01_09.funcdemo;


@FunctionalInterface
public interface Parser {

    String parse(String str);

    default String parse2(String str) {
        return "stub";
    }


}
