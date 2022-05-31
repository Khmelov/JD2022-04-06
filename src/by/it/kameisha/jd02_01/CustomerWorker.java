package by.it.kameisha.jd02_01;

public class CustomerWorker extends Thread implements CustomerAction, ShoppingCardAction {
    private final Customer customer;
    private final Shop shop;
    private final PriceListRepository repository;

    public CustomerWorker(Customer customer, Shop shop, PriceListRepository repository) {
        this.customer = customer;
        this.shop = shop;
        this.repository = repository;
    }

    @Override
    public void run() {
        enteredStore();
        takeCart();
        int count = RandomGenerator.get(2, 5);
        for (int i = 0; i < count; i++) {
            putToCart(chooseGood());
        }
        goOut();
    }

    @Override
    public void enteredStore() {
        System.out.println(customer + " enter to the shop " + shop);
    }

    @Override
    public Good chooseGood() {
        System.out.println(customer + " started to choose goods");
        int timeout = RandomGenerator.get(500, 2000);
        Timer.sleep(timeout);
        int indexRandomGood = RandomGenerator.get(repository.getGoodsList().size() - 1);
        Good good = new Good(repository.getGoodsList().get(indexRandomGood));
        System.out.println(customer + " choose " + good);
        System.out.println(customer + " finished to choose goods");
        return good;
    }

    @Override
    public void goOut() {
        System.out.println(customer + " leaves the shop " + shop);
    }

    @Override
    public void takeCart() {
        System.out.println(customer + " take a cart");
    }

    @Override
    public int putToCart(Good good) {
        customer.getShoppingCart().add(good);
        int timeout = RandomGenerator.get(100, 300);
        Timer.sleep(timeout);
        System.out.println(customer + " put " + good + " to cart. In cart " + customer.getShoppingCart().size());
        return customer.getShoppingCart().size();
    }
}
