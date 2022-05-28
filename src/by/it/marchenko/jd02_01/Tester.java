package by.it.marchenko.jd02_01;

public class Tester {
    public static void main(String[] args) {

        Printer printer = new Printer(System.out);
        Store store = new Store("BestStore", 1);
        StoreWorker storeWorker = new StoreWorker(printer, store);
        //storeWorker.start();

        Good good1 = new Good(1, "Pizza", 1.20d, "BYN");
        Good good2 = new Good(1_999_999_999, "Golden bread with diamond milk and silver core", 10000.457d);
        System.out.println(good1);
        System.out.println(good2);
        Customer cust1 = new Customer("Ivan", 1000);
        Customer cust2 = new Customer();
        Customer cust3 = new Customer();
        Customer cust4 = new Customer();
        System.out.println(cust1);
        System.out.println(cust2);
        System.out.println(cust3);
        System.out.println(cust4);


    }
}
