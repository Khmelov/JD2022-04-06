package by.it._examples_.jd01_07.abstractdemo;

abstract class Component {
    protected int x;
    protected int y;

    protected String getCoordinateString() {
        return String.format("X=%d, Y=%d", x, y);
    }

    abstract void show();
}

