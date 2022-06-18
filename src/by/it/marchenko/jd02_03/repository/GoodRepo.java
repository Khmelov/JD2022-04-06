package by.it.marchenko.jd02_03.repository;

import by.it.marchenko.jd02_03.interfaces.GoodActions;

import java.util.HashMap;
import java.util.Map;

public class GoodRepo implements GoodActions {
    private final Map<Integer, String> goodNames = new HashMap<>();

    @Override
    public String getName(int goodID) {
        return goodNames.get(goodID);
    }

    @Override
    public void setName(int goodID, String goodName) {
        goodNames.put(goodID, goodName);
    }
}
