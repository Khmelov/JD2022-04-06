package by.it.marchenko.jd02_01;

import by.it.marchenko.jd02_01.utility.Delayer;
import by.it.marchenko.jd02_01.utility.RandomGenerator;

import static by.it.marchenko.jd02_01.StoreConstant.*;

public class StoreWorker extends Thread {

    private final Printer out;
    private final Store store;


    public StoreWorker(Printer out, Store store) {
        this.out = out;
        this.store = store;
    }

    @Override
    public void run() {
        openStore();
        workStore();
        closeSore();
    }

    private void openStore() {
        out.println(store + OPENED_MESSAGE);
    }

    private void closeSore() {
        out.println(store + CLOSED_MESSAGE);
    }

    private void workStore() {
        for (int workTime = 0; workTime < WORK_TIME; workTime++) {
            int customerCountPerSecond = generateCustomerCountPerSecond(SIMPLY_CUSTOMER_LIMITATION);
            for (int customerCount = 0; customerCount < customerCountPerSecond; customerCount++) {
//                Delayer.performDelay(500);
                System.out.printf("Time: %-3d  Customer: %d.%n", workTime, ++customerCount);
            }
        }
    }

    private int generateCustomerCountPerSecond(boolean mode) {
        if (mode == SIMPLY_CUSTOMER_LIMITATION) {
            return RandomGenerator.getRandom(MAX_CUSTOMERS_COUNT_PER_SECOND);
        } else {
            //TODO implement complexCustomerLimitation
            return 10;
        }
    }
}
