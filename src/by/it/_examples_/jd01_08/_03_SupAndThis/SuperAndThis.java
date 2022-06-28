package by.it._examples_.jd01_08._03_SupAndThis;

public class SuperAndThis {
    public static void main(String[] args) {
        Point1D p=new Point3D(1,2,3);
    }

}

class Point1D {
    private int x;

    public Point1D(int x) {
        this.x = x;
    }
}

class Point2D extends Point1D {
    private int y;

    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }
}

class Point3D extends Point2D {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
