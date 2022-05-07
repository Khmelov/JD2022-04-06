package by.it.korennaya.jd01_08.oop;

public class Wardrobe extends Casewood{

    public Wardrobe(double width, double height, double depth, String woodType, int numberShelves) {
        super(width, height, depth, woodType, numberShelves);
    }

    @Override
    public void countWeight() {
        if (woodType.equals("oak")) {
            weight = weightOak * super.area;
            System.out.println("The weight of the wardrobe is " + weight + "kg.");
        }
        if (woodType.equals("alder")) {
            weight = weightAlder * super.area;
            System.out.println("The weight of the wardrobe is " + weight + "kg.");
        }
    }

    @Override
    public void confirmOrder() {
        System.out.println("We confirm your order for one wardrobe.");
    }
}
