package by.it.marchenko.jd02_02;

import by.it.marchenko.jd02_02.models.Manager;
import by.it.marchenko.jd02_02.models.Store;

public class Tester {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Manager manager2 = new Manager();
        Manager manager3 = new Manager();
        Manager manager4 = new Manager("John Snow");
        Manager manager5 = new Manager();
        System.out.println(manager);
        System.out.println(manager2);
        System.out.println(manager3);
        System.out.println(manager4);
        System.out.println(manager5);

        Store store = new Store("Gippo", manager);
        Store store2 = new Store("Gippo", manager4);
        System.out.println(store);
        System.out.println(store2);
        System.out.println(store2.getManager() + " manage " + store2);


    }


}
