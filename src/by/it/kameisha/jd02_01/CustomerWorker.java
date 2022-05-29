package by.it.kameisha.jd02_01;

public class CustomerWorker implements CustomerAction, ShoppingCardAction {
    @Override
    public void enteredStore() {

    }

    @Override
    public Good chooseGood() {
        return null;
    }

    @Override
    public void goOut() {

    }

    @Override
    public void takeCart() {

    }

    @Override
    public int putToCart(Good good) {
        return 0;
    }
}
