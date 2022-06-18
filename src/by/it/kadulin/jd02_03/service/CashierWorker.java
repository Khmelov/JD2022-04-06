package by.it.kadulin.jd02_03.service;


import by.it.kadulin.jd02_03.entity.*;
import by.it.kadulin.jd02_03.util.RandomGenerator;
import by.it.kadulin.jd02_03.util.Timer;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CashierWorker extends Thread {

    public static Object getMonitorCashier() {
        return monitorCashier;
    }

    static final Object monitorCashier = new Object();

    private final Cashier cashier;
    private final Shop shop;
    private Receipt receipt;
    private double summary = 0.;

    public CashierWorker(Cashier cashier, Shop shop) {
        this.cashier = cashier;
        this.shop = shop;
        setName(cashier.toString());
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        Manager manager = shop.getManager();
        Queue queue = shop.getQueue();

        while (queue.getQueueSize() != 0 || manager.isShopOpened()) {
            if (queue.cashierInWork() * Cashier.buyersPerCashier >= queue.getQueueSize() + Cashier.buyersPerCashier) {
                if (summary != 0) {
                    StringBuilder cashierClosed = new StringBuilder();
                    cashierClosed.append("****************************************\n");
                    cashierClosed.append(cashier).append(" is closed\n");
                    cashierClosed.append("total revenues ").append(summary).append("\n");
                    cashierClosed.append("****************************************\n");
                    System.out.println(cashierClosed);
                    summary = 0;
                }
                else if (summary == 0) {
                    StringBuilder cashierClosed = new StringBuilder();
                    cashierClosed.append("****************************************\n");
                    cashierClosed.append(cashier).append(" is closed\n");
                    cashierClosed.append("****************************************\n");
                    System.out.println(cashierClosed);
                }
                queue.cashierCloses();
                synchronized (monitorCashier) {
                    try {
                        monitorCashier.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (manager.isShopOpened()) {
                    System.out.println(cashier + " is opened");
                }
            }
            else {
                Buyer buyer = queue.extract();
                receipt = new Receipt(cashier);
                cashierProcess(buyer);

            }

        }
    }

    private void cashierProcess(Buyer buyer) {
        if (Objects.nonNull(buyer)) {
            System.out.println(cashier + " start service " + buyer);
            int timeOut = RandomGenerator.get(2000, 5000);
            Timer.sleep(timeOut);
            ShoppingCart shoppingCart = buyer.getShoppingCart();
            List<Good> listGoods = shoppingCart.getListGoods();
            for (Good good : listGoods) {
                receipt.addGoods(good);
            }
            summary = summary + receipt.getTotalPrice();
            receipt.createTable();
            System.out.println(cashier + " finished service " + buyer);
            synchronized (buyer) {
                buyer.setWaiting(false);
                buyer.notify();
            }
        }
        else {
//                это
//                Thread.onSpinWait();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
