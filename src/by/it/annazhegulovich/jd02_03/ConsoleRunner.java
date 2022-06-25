package by.it.annazhegulovich.jd02_03;

import by.it.annazhegulovich.jd02_03.entity.Manager;
import by.it.annazhegulovich.jd02_03.entity.Queue;
import by.it.annazhegulovich.jd02_03.entity.Store;
import by.it.annazhegulovich.jd02_03.service.StoreWorker;

public class ConsoleRunner {
    public static void main(String[] args) {
        Manager manager = new Manager(100);
        Queue gippoQueue = new Queue();
        Store gippo = new Store(" Gippo ", gippoQueue, manager);
        StoreWorker gippoWorker = new StoreWorker(gippo);
        gippoWorker.start();

    }
}
