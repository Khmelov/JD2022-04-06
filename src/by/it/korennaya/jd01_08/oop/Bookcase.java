package by.it.korennaya.jd01_08.oop;

public class Bookcase extends Casewood {


    public Bookcase(double width, double height, double depth, String woodType, int numberShelves) {
        super(width, height, depth, woodType, numberShelves);
    }

    @Override
    public void confirmOrder() {
        System.out.println("We have received your order for one bookcase.");
    }
    @Override
    public void countWeight() {
        if (woodType.equals("oak")) {
            weight = weightOak * super.area;
            System.out.println("Weight of the bookcase is " + weight + "kg.");
        }
        if (woodType.equals("alder")) {
            weight = weightAlder * super.area;
            System.out.println("Weight of the bookcase is " + weight + "kg.");
        }
    }

    public void placeBooks () {
        System.out.println("You can place " + ((int) (width / 0.03) * (Casewood.numberShelves + 1) + " books in your bookcase" + "."));
    }
}