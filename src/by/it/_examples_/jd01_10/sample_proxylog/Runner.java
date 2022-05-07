package by.it._examples_.jd01_10.sample_proxylog;

import by.it._examples_.jd01_10.sample_proxylog.logger.ProxyLogger;

public class Runner {
    public static void main(String[] args) {
        Sender sender = new SenderImpl();
        //закомментируйте следующую строку и логирование пропадет
        sender = ProxyLogger.getLoggedSender(sender);

        System.out.println("sum: $" + sender.getAmount());
        sender.createConnection("jdbc....");
        sender.openTransaction();
        sender.sendMoney(5);
        sender.closeTransaction();
        System.out.println("sum: $" + sender.getAmount());

        sender.openTransaction();
        sender.rollbackTransaction();
    }
}
