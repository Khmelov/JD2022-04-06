package by.it.korennaya.jd01_08.oop;

public abstract class Casewood implements Furniture {
    double width;
    double height;
    double depth;
    double weight;
    static String woodType;
    double area;
    static int numberShelves;

    public Casewood (double width, double height, double depth, String woodType, int numberShelves) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.woodType = woodType;
        this.numberShelves = numberShelves;
    }

    @Override
    public void confirmOrder() {
        System.out.println("We have received your order for one casewood. We'll confirm it after you specify the type.");
    }

    @Override
    public void countArea() {
        double areaCase = (width + height) * 2 * depth + (width * height);
        double areaShelves = numberShelves * width * depth;
        this.area = areaCase + areaShelves;
        System.out.println("The area of wooden parts is " + area + "sqm.");
        }
}
