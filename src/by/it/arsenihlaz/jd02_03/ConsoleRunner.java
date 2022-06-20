package by.it.arsenihlaz.jd02_03;

import by.it.arsenihlaz.jd02_03.entity.Manager;
import by.it.arsenihlaz.jd02_03.entity.Queue;
import by.it.arsenihlaz.jd02_03.entity.Shop;
import by.it.arsenihlaz.jd02_03.service.ShopWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue queue = new Queue();
        Shop shop = new Shop("Santa", queue, manager);
        ShopWorker shopWorker = new ShopWorker(shop);
        shopWorker.start();
    }
}
