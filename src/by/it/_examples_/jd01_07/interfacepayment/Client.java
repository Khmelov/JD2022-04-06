package by.it._examples_.jd01_07.interfacepayment;

import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) {
        Service service=new BankService();
        service.openAccount("Bill", "Gates");
        service.payment(BigDecimal.valueOf(123.45));
        service.closeAccount("Gates");
    }
}
