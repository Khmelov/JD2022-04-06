package by.it._examples_.jd01_07.interfacepayment;

import java.math.BigDecimal;

public class BankService implements Service{
    @Override
    public boolean openAccount(String login, String password) {
        System.out.printf("%s opened an account%n", login);
        return true;
    }

    @Override
    public boolean closeAccount(String login) {
        System.out.printf("Closed the account %s%n", login);
        return false;
    }

    @Override
    public void payment(BigDecimal amount) {
        System.out.printf("Payment $%-6.2f%n", amount.doubleValue());
    }
}
