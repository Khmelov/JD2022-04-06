package by.it.kadulin.jd02_02.entity;

import by.it.kadulin.jd02_02.service.CashierWorker;
import by.it.kadulin.jd02_02.util.Timer;

import java.util.ArrayList;

import java.util.List;


public class Receipt {
    private final List<Good> listOfGoodsBuy;
    private final Cashier cashier;


    public Receipt(Cashier cashier) {
        this.cashier = cashier;
        listOfGoodsBuy = new ArrayList<>();
    }

    public void addGoods(Good good) {
        listOfGoodsBuy.add(good);
    }

    public double getTotalPrice() {
        double price = 0;
        for (Good good : listOfGoodsBuy) {
            price += good.getPrice();
        }
        return price;
    }
    
    public void createTable() {
            String start = "╔═════════════════╦═════════════════╦═════════════════╦═════════════════╦═════════════════╗"; // 17
            System.out.println(start);
            String labels = "║   Cashier #1    ║   Cashier #2    ║   Cashier #3    ║   Cashier #4    ║   Cashier #5    ║";
            System.out.println(labels);
            String postLabels = "╠═════════════════╬═════════════════╬═════════════════╬═════════════════╬═════════════════╣";
            System.out.println(postLabels);
        switch (cashier.getCashierNumber()) {
            case 1 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║ %-15s ║                 ║                 ║                 ║                 ║", goodName);
                    System.out.println(goods);
                    String price = String.format("║ %15.2f ║                 ║                 ║                 ║                 ║", good.getPrice());
                    System.out.println(price);
                }
                String totalPrice = String.format("║ %-15s ║                 ║                 ║                 ║                 ║\n║ %15.2f ║                 ║                 ║                 ║                 ║", "Total price", getTotalPrice());
                System.out.println(totalPrice);
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝";
                System.out.println(postGoods);
            }
            case 2 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║ %-15s ║                 ║                 ║                 ║", goodName);
                    System.out.println(goods);
                    String price = String.format("║                 ║ %15.2f ║                 ║                 ║                 ║", good.getPrice());
                    System.out.println(price);
                }
                String totalPrice = String.format("║                 ║ %-15s ║                 ║                 ║                 ║\n║                 ║ %15.2f ║                 ║                 ║                 ║", "Total price", getTotalPrice());
                System.out.println(totalPrice);
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝";
                System.out.println(postGoods);
            }
            case 3 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║ %-15s ║                 ║                 ║", goodName);
                    System.out.println(goods);
                    String price = String.format("║                 ║                 ║ %15.2f ║                 ║                 ║", good.getPrice());
                    System.out.println(price);
                }
                String totalPrice = String.format("║                 ║                 ║ %-15s ║                 ║                 ║\n║                 ║                 ║ %15.2f ║                 ║                 ║", "Total price", getTotalPrice());
                System.out.println(totalPrice);
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝";
                System.out.println(postGoods);
            }
            case 4 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║                 ║ %-15s ║                 ║", goodName);
                    System.out.println(goods);
                    String price = String.format("║                 ║                 ║                 ║ %15.2f ║                 ║", good.getPrice());
                    System.out.println(price);
                }
                String totalPrice = String.format("║                 ║                 ║                 ║ %-15s ║                 ║\n║                 ║                 ║                 ║ %15.2f ║                 ║", "Total price", getTotalPrice());
                System.out.println(totalPrice);
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝";
                System.out.println(postGoods);
            }
            case 5 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║                 ║                 ║ %-15s ║", goodName);
                    System.out.println(goods);
                    String price = String.format("║                 ║                 ║                 ║                 ║ %15.2f ║", good.getPrice());
                    System.out.println(price);
                }
                String totalPrice = String.format("║                 ║                 ║                 ║                 ║ %-15s ║\n║                 ║                 ║                 ║                 ║ %15.2f ║", "Total price", getTotalPrice());
                System.out.println(totalPrice);
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝";
                System.out.println(postGoods);
            }
        }
        }
}
