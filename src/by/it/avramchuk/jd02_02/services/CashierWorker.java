package by.it.avramchuk.jd02_02.services;

import by.it.avramchuk.jd02_02.util.RandomGenerator;
import by.it.avramchuk.jd02_02.util.Timer;
import by.it.avramchuk.jd02_02.entity.*;
import by.it.avramchuk.jd02_02.interfaces.CashierAction;
import by.it.avramchuk.jd02_02.repository.PriceListRepository;
import java.util.List;
import java.util.Objects;


public class CashierWorker extends Thread implements CashierAction {

    private final Cashier cashier;
    private final Shop shop;
    private final CashBox cashBox;
    private volatile boolean needToClose;

    public CashierWorker(Cashier cashier,CashBox cashBox, Shop shop ) {
        this.cashier = cashier;
        this.shop = shop;
        this.cashBox = cashBox;
        this.needToClose = false;
    }
    public void setNeedToClose(boolean value){
        this.needToClose = value;
    }

    @Override
    public void run() {
        openCash();
        while (!needToClose){
            serveCustomer();
        }
        closeCash();
    }

    @Override
    public void openCash() {
        System.out.println(cashier+ " opened "+cashBox.name());
    }

    @Override
    public void closeCash() {
        synchronized (System.out) {
            System.out.println("\n" + cashier + " closed " + cashBox.name());
            System.out.printf("%s%5.2f\n\n", "Total cash....", cashBox.getTotalCash());
        }
    }

    @Override
    public void serveCustomer() {
        ShopQueue queue = shop.getQueue();
        Customer customer = queue.extract();
        if (Objects.nonNull(customer)) {
            System.out.println(cashier + " started service " + customer);
            int timeOut = RandomGenerator.get(2000, 5000);
            Timer.sleep(timeOut);
            cashBox.addSum(giveCheck(customer));
            System.out.println(cashier + " finished service " + customer);
            synchronized (customer.getMonitor()) {
                customer.isWaiting = false;
                customer.notify();
            }
        } else {Thread.onSpinWait();}
    }

    public double giveCheck(Customer customer) {
        ShoppingCart myCart = customer.getMyCart();
        List<Good> goodsInCart = myCart.getGoodsInCart();
        String[] goods = goodsInCart.stream()
                .map(Good::toString)
                .toArray(String[]::new);
        double totalSum=0;
        synchronized (System.out) {
            System.out.println("\ncheck for " + customer + ":");
            for (String good : goods) {
                Double price = PriceListRepository.priceList.get(good);
                totalSum += price;
                System.out.printf("%10s....%5f\n", good, price);
            }
            System.out.println("--------");
            System.out.printf("%s%.2f\n\n","Total sum: ", totalSum);
        }
        return totalSum;
    }
}
