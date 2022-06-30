package by.it.edeborg.jd02_03.service;

import by.it.edeborg.jd02_03.organization.*;
import by.it.edeborg.jd02_03.util.RandomGenerator;
import by.it.edeborg.jd02_03.util.Timer;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class TellerWorker implements Runnable {
    public static final int MIN_TIMEOUT_SERVE_CUSTOMER = 2000;
    public static final int MAX_TIMEOUT_SERVE_CUSTOMER = 5000;
    public static final int TIMEOUT_WAIT = 100;
    private final Teller teller;
    private final Shop shop;

    public TellerWorker(Teller teller, Shop shop) {
        this.teller = teller;
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(teller + " opened");
        Manager manager = shop.getManager();
        Queue queue = shop.getQueue();
        while (!manager.shopClosed()) {
            Customer customer = queue.extract();
            if (Objects.nonNull(customer)) {
                synchronized (customer.getMonitor()) {
                    serveCustomer(customer);
                    customer.setWaiting(false);
                    customer.notify();
                }
            } else {
                synchronized (shop.getQueue()) {
                    try {
                        queue.wait(TIMEOUT_WAIT);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        System.out.println(teller + " closed. Total revenue: " + teller.getRevenue());
    }

    private void serveCustomer(Customer customer) {
        System.out.println(teller + " started service " + customer);
        int timeout = RandomGenerator.get(MIN_TIMEOUT_SERVE_CUSTOMER, MAX_TIMEOUT_SERVE_CUSTOMER);
        Timer.sleep(timeout);
        int revenue = printCheck(customer);
        teller.addRevenue(revenue);
        System.out.println(teller + " finished service " + customer);
    }

    private int printCheck(Customer customer) {
        List<SomethingGood> shoppingCart = customer.getShoppingCart();
        Map<SomethingGood, Integer> priceList = shop.getRepository().getPriceList();
        int revenue = 0;
        StringJoiner check = new StringJoiner("\n");
        check.add(String.format("%10s print check to %10s", teller, customer));
        for (SomethingGood good : shoppingCart) {
            for (Map.Entry<SomethingGood, Integer> entry : priceList.entrySet()) {
                if (good.toString().equals(entry.getKey().toString())) {
                    check.add(String.format("%15s...........%-10d", good, entry.getValue()));
                    revenue = revenue + entry.getValue();
                }
            }
        }
        check.add(String.format("%15s:..........%-10d", "total", revenue));
        System.out.println(check);
        return revenue;
    }
}
