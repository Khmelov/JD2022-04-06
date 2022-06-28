package by.it._examples_.jd01_12;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapConstructor {
    private static final int capacity = 4;

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>(capacity, 1.0f, true) {
            //Метод отвечает на вопрос, нужно ли удалять самый старый элемент
            @Override
            protected boolean
            removeEldestEntry(Map.Entry<Integer, String> eldest) {
                //Тут можно сравнить с capacity и вернуть true для удаления элемента,
                //иначе старое поведение (там просто false, т.е. не удалять)
                return this.size() > capacity || super.removeEldestEntry(eldest);
            }
        };
        hashMap.put(1, "a");
        System.out.println(hashMap);
        hashMap.put(2, "a");
        System.out.println(hashMap);
        hashMap.put(3, "a");
        System.out.println(hashMap);
        hashMap.put(4, "a"); hashMap.get(1);
        System.out.println(hashMap);
        hashMap.put(5, "a"); hashMap.get(2);
        System.out.println(hashMap);
        hashMap.get(3);
        System.out.println(hashMap);
    }
}
