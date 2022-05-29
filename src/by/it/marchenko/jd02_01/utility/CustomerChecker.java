package by.it.marchenko.jd02_01.utility;

import by.it.marchenko.jd02_01.services.StoreWorker;

import java.util.LinkedList;

import static by.it.marchenko.jd02_01.constants.StoreConstant.REAL_ONE_SECOND;

public class CustomerChecker extends Thread {

    private final StoreWorker storeWorker;

    public CustomerChecker(StoreWorker storeWorker) {
        this.storeWorker = storeWorker;
    }

    public void run() {
        Delayer delayer = new Delayer();
        int index = 0;
        LinkedList<Integer> totalList = new LinkedList<>();
        LinkedList<Integer> currentList = new LinkedList<>();
        while (storeWorker.isAlive()) {
            delayer.performDelay(REAL_ONE_SECOND);
            int totalCustomerCount = storeWorker.getTotalCustomerCount();
            int currentCustomerCount = storeWorker.getCurrentCustomerCount();
            String checkResult = String.format(
                    "Time: %3ds, Total customer count: %3d, Current customer count: %3d",
                    index++, totalCustomerCount, currentCustomerCount);
            totalList.addLast(totalCustomerCount);
            currentList.addLast(currentCustomerCount);
            System.out.println(checkResult);
        }
        printResult(totalList);
        printResult(currentList);
    }

    private void printResult(LinkedList<Integer> list) {

        int timeIndex = 0;
        for (Integer element : list) {
            System.out.printf("%4d", element);
            if (++timeIndex % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("-".repeat(100));
    }
}
