package by.it.kadulin.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class ShopWorker extends Thread {
    public static final int TIME_WORK = 120;
    private final Shop shop;
    private static PriceListRepo priceListRepo = new PriceListRepo();
    private int countVisitors = 0;
    private boolean markPensioner = false;
    public ShopWorker(Shop shop) {
        this.shop = shop;
    }


    @Override
    public void run() {
        System.out.println(shop + " opened");
        List<CustomerWorker> customerWorkerList = new ArrayList<>();

        for (int time = 0; time < TIME_WORK; time++) {
            int second = time % 60;
            if (second <= 29) {
                while (customerWorkerList.size() <= (second + 10)) {
                        addCustomers(customerWorkerList);
                }
            }
            else if (second > 30) {
                while (customerWorkerList.size() <= (40 + (30 - second))) {
                        addCustomers(customerWorkerList);
                }
            }
            customerWorkerList.removeIf(customerWorker -> customerWorker.getState() == State.TERMINATED);
            Timer.sleep(1000);
        }
        for (CustomerWorker customerWorker : customerWorkerList) {
            try {
                customerWorker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(shop + " closed");
    }

    private void addCustomers(List<CustomerWorker> customerWorkerList) {
        Customer customer = null;
        if (countVisitors % 2 == 1) {
            customer = new Student(++countVisitors);
        } else {
            if (!markPensioner) {
                customer = new Customer(++countVisitors);
                markPensioner = true;
            } else if (markPensioner) {
                customer = new Pensioner(++countVisitors);
                markPensioner = false;
            }
        }

        CustomerWorker customerWorker = new CustomerWorker(customer, shop);
        customerWorker.start();
        customerWorkerList.add(customerWorker);

    }
}
