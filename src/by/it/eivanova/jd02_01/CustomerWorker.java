package by.it.eivanova.jd02_01;

public class CustomerWorker extends Thread {

    private final Customer customer;


    public CustomerWorker(Customer customer) {
        this.customer = customer;
    }
}
