package by.it.marchenko.jd02_01;

import by.it.marchenko.jd02_01.models.Good;
import by.it.marchenko.jd02_01.models.ShoppingCart;
import by.it.marchenko.jd02_01.models.Store;
import by.it.marchenko.jd02_01.models.Stock;
import by.it.marchenko.jd02_01.repository.GoodRepo;
import by.it.marchenko.jd02_01.repository.PriceListRepo;
import by.it.marchenko.jd02_01.repository.StockRepo;
import by.it.marchenko.jd02_01.services.StockWorker;
import by.it.marchenko.jd02_01.utility.RandomGenerator;
import by.it.marchenko.jd02_01.services.StoreWorker;

import static by.it.marchenko.jd02_01.constants.ShoppingCartConstant.*;

public class Tester {
    public static void main(String[] args) {

        Printer printer = new Printer(System.out);
        Store store = new Store("BestStore", 1);
        StockRepo stockRepo = new StockRepo();
        GoodRepo goodRepo = new GoodRepo();
        PriceListRepo priceListRepo = new PriceListRepo();
        StoreWorker storeWorker = new StoreWorker(stockRepo, store, goodRepo, priceListRepo, printer);
        //storeWorker.start();


        int goodAmount = RandomGenerator.getRandom(MIN_CART_CAPACITY, MAX_CART_CAPACITY);
        ShoppingCart cart = new ShoppingCart(3);
        Good good1 = new Good(1, "Pizza", 1.20d, "BYN");
        Good good2 = new Good(2, "Golden bread with diamond milk and silver core", 10000.457d);
        Good good3 = new Good(3);
        cart.addGoodToCart(good1);
        cart.addGoodToCart(good2);
        cart.addGoodToCart(good3);

        //StockRepo stockRepo = new StockRepo();


        Stock stock = new Stock("StoreStore#1", 100, stockRepo);
        System.out.println(stock);
        //
        //goodRepo = new GoodRepo();
        //
        StockWorker stockWorker =
                new StockWorker(stockRepo, goodRepo, priceListRepo);
        stockWorker.start();





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
