package by.it.marchenko.jd02_01;

public class Tester {
    public static void main(String[] args) {

        Printer printer = new Printer(System.out);
        Store store = new Store("BestStore", 1);
        StoreWorker storeWorker = new StoreWorker(printer, store);
        storeWorker.start();
/*
        Good good1 = new Good("Pizza", 1.20d, "BYN");
        Good good2 = new Good("Golden bread with diamond milk and silver core", 10000.457d);
        Good good3 = new Good();
        Good good4 = new Good();
        System.out.println(good1);
        System.out.println(good2);
        System.out.println(good3);
        System.out.println(good4);
        Customer cust1 = new Customer("Ivan", 1000);
        Customer cust2 = new Customer();
        System.out.println(cust1);
        System.out.println(cust2);
        CustomerWorker customerWorker = new CustomerWorker(cust1, store, printer);
        customerWorker.start();
        CustomerWorker customerWorker2 = new CustomerWorker(cust2, store, printer);
        //customerWorker2.setPrinter(printer);

        customerWorker2.start();


 */

    }
}
