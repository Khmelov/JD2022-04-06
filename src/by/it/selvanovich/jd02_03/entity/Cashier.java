package by.it.selvanovich.jd02_03.entity;

public class Cashier {

    public final String name;
    public int totalGain;
    public int totalGoods;

    public Cashier(int number) {
        this.name = "Cashier №" + number;
        totalGain = 0;
        totalGoods = 0;
    }

    @Override
    public String toString() {
        return "\t" + name;
    }

    public void addGain(int gain) {
        totalGain += gain;
    }

    public void addGoods(int goods) {
        totalGoods += goods;
    }

    public int getTotalGain() {
        return totalGain;
    }

    public int getTotalGoods() {
        return totalGoods;
    }


}
