package by.it.marchenko.jd02_02.interfaces;

public interface StockAction {
    void addGoodIDToStock(int id, int amount);

    @SuppressWarnings("unused")
    int getAmountOfGood(int id);

    int getOccupiedPlace();

    int getStockSize();

    boolean getFromStock(int id);

    //boolean

}
