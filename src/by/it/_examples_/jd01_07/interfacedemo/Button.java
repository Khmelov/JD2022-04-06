package by.it._examples_.jd01_07.interfacedemo;

import java.io.Serializable;

class Button implements Clickable, Serializable {
    @Override
    public void doubleClick() {
        System.out.println("Button double click");
    }
}