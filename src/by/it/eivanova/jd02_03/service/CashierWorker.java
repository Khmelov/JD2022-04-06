package by.it.eivanova.jd02_03.service;

import by.it._classwork_.jd02_03.entity.*;
import by.it.eivanova.jd02_03.entity.*;
import by.it.eivanova.jd02_03.entity.Cashier;
import by.it.eivanova.jd02_03.entity.Customer;
import by.it.eivanova.jd02_03.entity.Good;
import by.it.eivanova.jd02_03.entity.Shop;
import by.it.eivanova.jd02_03.interfaces.CashierAction;
import by.it.eivanova.jd02_03.respository.PriceListRepository;
import by.it.eivanova.jd02_03.util.RandomGenerator;
import by.it.eivanova.jd02_03.util.Timer;

import java.util.List;
import java.util.Objects;

public class CashierWorker extends Thread implements CashierAction {

    private final Cashier cashier;
    private final Shop shop;
    private final CashBox cashBox;
    private volatile boolean needToClose;

    public CashierWorker(Cashier cashier, CashBox cashBox, Shop shop){
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
    public void serveCustomer() {
        ShopQueue queue = shop.getQueue();
        Customer customer = queue.extract();
        if (Objects.nonNull(customer)){
            System.out.println(cashier + " started service " + customer);
            int timeOut = RandomGenerator.get(2000,5000);
            Timer.sleep(timeOut);
            cashBox.addSum(giveCheck(customer));
            System.out.println(cashier + " finished service " + customer);
            synchronized (customer.getMonitor()){
                customer.isWaiting = false;
                customer.notify();
            }
        } else {Thread.onSpinWait();}
    }

    public double giveCheck(Customer customer){
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
                totalSum +=price;
                System.out.printf("%10s....%5f\n", good, price);
            }
            System.out.println("--------");
            System.out.printf("%s%.2f\n\n","Total sum: ", totalSum);
        }
        return totalSum;
    }

        @Override
        public void closeCash() {
        synchronized (System.out){
            System.out.println("\n" + cashier + " closed " + cashBox.name());
            CashBox[] cashBoxes = CashBox.values();
            double totalAllBoxes=0;
            for (CashBox box : cashBoxes){
            totalAllBoxes+= box.getTotalCash();
            }

            System.out.print("\u250c");
            for (int i = 0; i < 6; i++) {
                System.out.print("\u2500".repeat(8)+"\u252c");
            }

            System.out.println("\u2500".repeat(8)+"\u2510");

            System.out.print("\u2502");
            for (CashBox box : cashBoxes){
                System.out.printf("%8s\u2502", box.name());
            }

            System.out.printf("%8s\u2502","Size Q");
            System.out.printf("%8s\u2502\n","Total");

            System.out.print("\u251c");
            for (int i = 0; i < 6; i++) {
                System.out.print("\u2500".repeat(8)+"\u253c");
            }
            System.out.println("\u2500".repeat(8)+"\u2524");

            System.out.print("\u2502");
            for (CashBox box : cashBoxes){
                System.out.printf("%8.2f\u2502", box.getTotalCash());
            }
            System.out.printf("%8d\u2502",shop.getQueue().getSize());
            System.out.printf("%8.2f\u2502\n",totalAllBoxes);

            System.out.print("\u2514");
            for (int i = 0; i < 6; i++) {
                System.out.print("\u2500".repeat(8)+"\u2534");
            }
            System.out.println("\u2500".repeat(8)+"\u2518");
        }
    }
}
