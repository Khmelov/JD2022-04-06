package by.it.korennaya.jd01_08.oop;

public class App {

    public static void main(String[] args) {
        Bookcase bookcase = new Bookcase(1.5,2.5,0.3,"alder", 6);
        bookcase.confirmOrder();
        bookcase.countArea();
        System.out.println("The bookcase will be produced of " + Casewood.woodType + ".");
        bookcase.countWeight();
        bookcase.placeBooks();
        System.out.println();

        Bookcase bookcase1 = new Bookcase(3,3.0,0.3,"oak", 7);
        bookcase.confirmOrder();
        bookcase.countArea();
        System.out.println("The bookcase will be produced of " + Casewood.woodType + ".");
        bookcase.countWeight();
        bookcase.placeBooks();
        System.out.println();

        Casewood casewood = new Bookcase(1.5,2.5,0.3,"alder", 6);
        casewood.confirmOrder();
        bookcase.countArea();
        System.out.println("The bookcase will be produced of " + Casewood.woodType + ".");
        bookcase.countWeight();
        System.out.println();

        Furniture furniture = new Bookcase(3.0,2.5,0.3,"alder", 6);
        furniture.confirmOrder();
        furniture.countArea();
        furniture.countWeight();
        System.out.println();

        Wardrobe wardrobe = new Wardrobe(2.0, 3.0, 0.45, "oak", 3);
        wardrobe.confirmOrder();
        wardrobe.countArea();
        System.out.println("The wardrobe will be produced of " + Casewood.woodType + ".");
        wardrobe.countWeight();
        System.out.println();
    }
}
