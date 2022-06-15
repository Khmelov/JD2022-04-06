package by.it.annazhegulovich.jd02_01;

public class ConsoleRunner {
    public static void main(String[] args) {
        Store gippo = new Store(" Gippo ");
        StoreWorker gippoWorker = new StoreWorker(gippo);
        gippoWorker.start();

    }
}
