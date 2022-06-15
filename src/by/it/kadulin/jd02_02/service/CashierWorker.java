package by.it.kadulin.jd02_02.service;


import by.it.kadulin.jd02_02.entity.*;
import by.it.kadulin.jd02_02.util.RandomGenerator;
import by.it.kadulin.jd02_02.util.Timer;

import java.io.FileReader;
import java.util.List;
import java.util.Objects;

public class CashierWorker extends Thread {

    public static Object getMonitorCashier() {
        return monitorCashier;
    }

    static final Object monitorCashier = new Object();

    private final Cashier cashier;
    private final Shop shop;
    private Receipt receipt;

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
//        switch (cashier.getCashierNumber()) {
//            case 1: {
//                while (queue.getQueueSize() > 0) {
//                    Buyer buyer = queue.extract();
//                    receipt = new Receipt(cashier);
//                    cashierProcess(buyer);
//                }
//                break;
//            }
//            case 2: {
//                while (queue.getQueueSize() > 5) {
//                    Buyer buyer = queue.extract();
//                    receipt = new Receipt(cashier);
//                    cashierProcess(buyer);
//                }
//                break;
//            }
//            case 3: {
//                while (queue.getQueueSize() > 10) {
//                    Buyer buyer = queue.extract();
//                    receipt = new Receipt(cashier);
//                    cashierProcess(buyer);
//                }
//                break;
//            }
//            case 4: {
//                while (queue.getQueueSize() > 15) {
//                    Buyer buyer = queue.extract();
//                    receipt = new Receipt(cashier);
//                    cashierProcess(buyer);
//                }
//                break;
//            }
//            case 5: {
//                while (queue.getQueueSize() > 20) {
//                    Buyer buyer = queue.extract();
//                    receipt = new Receipt(cashier);
//                    cashierProcess(buyer);
//                }
//            }
//            break;
//        }
        while (queue.getQueueSize() != 0 || manager.isShopOpened()) {
            if (queue.cashierInWork() * Cashier.buyersPerCashier >= queue.getQueueSize() + Cashier.buyersPerCashier) {
                System.out.println(cashier + " is closed");
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
//                if (queue.getQueueSize() == 0 && !manager.isShopOpened()) {
//                    System.out.println(cashier + " is closed");
//                    break;
//                }
            }

        }
//        System.out.println(cashier + " closed");
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
