package by.it._examples_.jd01_07.interfacepayment;

import java.math.BigDecimal;

@SuppressWarnings("ALL")
public interface Service {

    boolean openAccount(String login,
                        String password);

    boolean closeAccount(String login);

    void payment(BigDecimal amount);

}
