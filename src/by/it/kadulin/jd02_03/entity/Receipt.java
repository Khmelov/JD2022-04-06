package by.it.kadulin.jd02_03.entity;

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
        StringBuilder result = new StringBuilder();
        String start = "╔═════════════════╦═════════════════╦═════════════════╦═════════════════╦═════════════════╗\n"; // 17
        String labels = "║   Cashier #1    ║   Cashier #2    ║   Cashier #3    ║   Cashier #4    ║   Cashier #5    ║\n";
        String postLabels = "╠═════════════════╬═════════════════╬═════════════════╬═════════════════╬═════════════════╣\n";
        result.append(start).append(labels).append(postLabels);
        switch (cashier.getCashierNumber()) {
            case 1 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║ %-15s ║                 ║                 ║                 ║                 ║\n", goodName);
                    String price = String.format("║ %15.2f ║                 ║                 ║                 ║                 ║\n", good.getPrice());
                    result.append(goods).append(price);
                }
                String totalPrice = String.format("║ %-15s ║                 ║                 ║                 ║                 ║\n║ %15.2f ║                 ║                 ║                 ║                 ║\n", "Total price", getTotalPrice());
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝\n";
                result.append(totalPrice).append(postGoods);
            }
            case 2 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║ %-15s ║                 ║                 ║                 ║\n", goodName);
                    String price = String.format("║                 ║ %15.2f ║                 ║                 ║                 ║\n", good.getPrice());
                    result.append(goods).append(price);
                }
                String totalPrice = String.format("║                 ║ %-15s ║                 ║                 ║                 ║\n║                 ║ %15.2f ║                 ║                 ║                 ║\n", "Total price", getTotalPrice());
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝\n";
                result.append(totalPrice).append(postGoods);
            }
            case 3 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║ %-15s ║                 ║                 ║\n", goodName);
                    String price = String.format("║                 ║                 ║ %15.2f ║                 ║                 ║\n", good.getPrice());
                    result.append(goods).append(price);
                }
                String totalPrice = String.format("║                 ║                 ║ %-15s ║                 ║                 ║\n║                 ║                 ║ %15.2f ║                 ║                 ║\n", "Total price", getTotalPrice());
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝\n";
                result.append(totalPrice).append(postGoods);
            }
            case 4 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║                 ║ %-15s ║                 ║\n", goodName);
                    String price = String.format("║                 ║                 ║                 ║ %15.2f ║                 ║\n", good.getPrice());
                    result.append(goods).append(price);
                }
                String totalPrice = String.format("║                 ║                 ║                 ║ %-15s ║                 ║\n║                 ║                 ║                 ║ %15.2f ║                 ║\n", "Total price", getTotalPrice());
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝\n";
                result.append(totalPrice).append(postGoods);
            }
            case 5 -> {
                for (Good good : listOfGoodsBuy) {
                    String goodName = good.getName();
                    if (goodName.length() > 15) {
                        String substring = goodName.substring(0, 11);
                        goodName = substring + "...";
                    }
                    String goods = String.format("║                 ║                 ║                 ║                 ║ %-15s ║\n", goodName);
                    String price = String.format("║                 ║                 ║                 ║                 ║ %15.2f ║\n", good.getPrice());
                    result.append(goods).append(price);
                }
                String totalPrice = String.format("║                 ║                 ║                 ║                 ║ %-15s ║\n║                 ║                 ║                 ║                 ║ %15.2f ║\n", "Total price", getTotalPrice());
                String postGoods = "╚═════════════════╩═════════════════╩═════════════════╩═════════════════╩═════════════════╝\n";
                result.append(totalPrice).append(postGoods);
            }
        }
        System.out.println(result);
    }
}
