package by.it._examples_.jd01_10.sample_proxylog;

import by.it._examples_.jd01_10.sample_proxylog.logger.Log;

public class SenderImpl implements Sender {

    private double amount = 10;

    @Override
    @Log(text = "connection is opened", level = Log.Level.MESSAGES)
    public void createConnection(String uri) {
        System.out.println("createConnect to " + uri + "...");
    }

    @Override
    @Log(text = "start transaction")
    public void openTransaction() {
        System.out.println("openTransaction...");
    }

    @Override
    @Log(text = "processing", level = Log.Level.DEBUG)
    public void sendMoney(double count) {
        amount += count;
        System.out.println("sendMoney $" + count + "...");
    }

    @Override
    @Log(text = "processing", level = Log.Level.DEBUG)
    public double getAmount() {
        return amount;
    }

    @Override
    @Log(text = "connection is opened")
    public void closeTransaction() {
        System.out.println("closeTransaction...");
    }

    @Override
    @Log(text = "connection is opened", level = Log.Level.ERROR)
    public void rollbackTransaction() {
        System.out.println("rollbackTransaction...");
    }

}
