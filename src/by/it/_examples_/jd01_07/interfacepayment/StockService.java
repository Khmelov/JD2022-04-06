package by.it._examples_.jd01_07.interfacepayment;

import java.math.BigDecimal;

public class StockService implements Service{
    @Override
    public boolean openAccount(String login, String password) {
        System.out.printf("Create stock account %s%n", login);
        return true;
    }

    @Override
    public boolean closeAccount(String login) {
        System.out.printf("Closed stock account %s%n", login);
        return false;
    }

    @Override
    public void payment(BigDecimal amount) {
        System.out.printf("Add balance $%-6.2f%n", amount.doubleValue());
    }
}
