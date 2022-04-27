package by.it._examples_.jd01_07.interfacedemo;

interface Clickable {
    int MAX_COUNT = 5;  //всегда public static final

    void doubleClick(); //всегда public abstract - не реализован

    default void click() { //реализация возможна в Java 8+
        System.out.println("One click");
    }
}








