package by.it.annazhegulovich.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction {
    private final Customer customer;
    private final Store store;

    public CustomerWorker(Customer customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    @Override
    public void run() {
        enteredStore(); //вошел в магазин (мгновенно)
        chooseGood(); //выбрал товар (от 0,5 до 2 секунд)
        goOut();//отправился на выход(мгновенно)
    }

    @Override
    public void enteredStore() {
        System.out.println(customer+" entered "+store);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer+" started choose goods ");
        int timeout = RandomGenerator.get(500,2000);
        Timer.sleep(timeout);
        Good good= new Good();
        System.out.println(customer + " choose "+good);
        System.out.println(customer+" finished choose goods ");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer+" leaved "+store);

    }
}
