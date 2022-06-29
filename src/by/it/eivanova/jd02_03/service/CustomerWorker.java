package by.it.eivanova.jd02_03.service;

import by.it._classwork_.jd02_03.entity.Queue;
import by.it.eivanova.jd02_03.entity.*;
import by.it.eivanova.jd02_03.interfaces.CashierAction;
import by.it.eivanova.jd02_03.interfaces.CustomerAction;
import by.it.eivanova.jd02_03.interfaces.ShoppingCardAction;
import by.it.eivanova.jd02_03.respository.PriceListRepository;
import by.it.eivanova.jd02_03.util.RandomGenerator;
import by.it.eivanova.jd02_03.util.Timer;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {

    private final Customer customer;
    private final Shop shop;
    private ShoppingCart myCart;
    private static final Semaphore semaphoreChoseGood = new Semaphore(20);
    private static final Semaphore semaphoreCart = new Semaphore(50);


    public CustomerWorker(Customer customer, Shop shop){
        this.customer = customer;
        this.shop = shop;
        shop.getManager().customerEnter();
    }

    @Override
    public void run() {
        enteredStore();
        try {
            semaphoreCart.acquire();
            takeCart();
            chooseGood();
            goToQueue();
            goOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
          semaphoreCart.release();
        }
    }

    @Override
    public void enteredStore(){
        System.out.println(customer+" enter to the "+shop);
    }

    @Override
    public void chooseGood() {
        try {
            semaphoreChoseGood.acquire();
            int goodsMayToBuy = customer.mayToBuy();
            System.out.println(customer + " starts to choose goods");
            for (int i = 0; i < goodsMayToBuy; i++) {
                int timeout = RandomGenerator.get(500, 2000) * customer.getSpeedFactor();
                Timer.sleep(timeout);
                Set<String> goodList = PriceListRepository.priceList.keySet();

                String[] strings = goodList.toArray(String[]::new);
                int randomIndex = RandomGenerator.get(strings.length - 1);
                Good good = new Good(strings[randomIndex]);
                System.out.println(customer + " choosed " + good);
                putToCart(good);
            }

            System.out.println(customer + " finished. He choosed " + myCart.goodsInCart.size() + " goods");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
        semaphoreChoseGood.release();
        }
    }


    @Override
    public void goOut(){
        System.out.println(customer+" leaves the "+shop);
    }

    @Override
    public void takeCart() {
        int timeout = RandomGenerator.get(100,300) * customer.getSpeedFactor();
        Timer.sleep(timeout);
        myCart = new ShoppingCart();
        System.out.println(customer+" took the cart");
    }

    @Override
    public int putToCart(Good good){
        int timeout = RandomGenerator.get(100, 300) * customer.getSpeedFactor();
        Timer.sleep(timeout);
        System.out.println(customer+" put "+good+ " to his cart");
        return myCart.addGoodToCart(good);
    }

    @Override
    public void goToQueue(){
        if (myCart.goodsInCart.size() != 0){
          ShopQueue queue = shop.getQueue();
          synchronized (customer.getMonitor()){

                System.out.println(customer + " go to the queue");
                customer.setMyCart(myCart);
                queue.add(customer);
                customer.isWaiting = true;
                while (customer.isWaiting){
                    try {
                        customer.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(customer + " leaves the queue");
            }
        }
    }
}
