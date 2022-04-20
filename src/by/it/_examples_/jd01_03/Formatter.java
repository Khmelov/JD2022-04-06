package by.it._examples_.jd01_03;

public class Formatter {
    public static void main(String[] args) {
        System.out.println("printf demo:");
        System.out.printf("%-5s%-12s%-25s%-10s%n", "Код", "За единиц", "Валюты", "Бел. рублей");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "RUR", 100, "Российский рубль", 3.48);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "EUR", 1, "Евро", 3.10123);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "USD", 1, "Доллар США", 2.6103);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "GBP", 1, "Фунт стерлингов", 3.3502);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "DKK", 10, "Датская крона", 4.162);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "AUD", 1, "Австралийский доллар", 1.901);
        System.out.printf("%-5s%-12d%-25s%-10.4f%n", "KZT", 100, "Казахский тенге", 0.61);

        System.out.println("\nprintf2 demo");
        for (int i = 0; i < 16; i++) {
            final String bin = String
                    .format("%4s", Integer.toBinaryString(i))
                    .replace(' ', '0');
            System.out.printf("DEC:%1$03d OCT:%1$03o HEX:%1$03x BIN:%2$2s %n", i, bin);
        }
    }
}
