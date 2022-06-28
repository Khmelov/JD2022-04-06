package by.it._classwork_.jd02_02;

import by.it._classwork_.jd02_02.entity.Manager;
import by.it._classwork_.jd02_02.entity.Queue;
import by.it._classwork_.jd02_02.entity.Shop;
import by.it._classwork_.jd02_02.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
      //  for (int i = 0; i < 100; i++) {
            Manager manager = new Manager(100);
            Queue euroMarketQueue = new Queue();
            Shop shop = new Shop("EuroMarket", euroMarketQueue, manager);
            ShopWorker shopWorker = new ShopWorker(shop);
            shopWorker.start();
      //  }
//        Queue sosediQueue = new Queue();
//        Shop shop2 = new Shop("Sosedi", sosediQueue);
//        ShopWorker shopWorker2 = new ShopWorker(shop2);
//        shopWorker2.start();
    }

}
