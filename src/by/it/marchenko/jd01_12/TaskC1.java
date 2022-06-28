package by.it.marchenko.jd01_12;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TaskC1 {

    public static final String END_INPUT_COMMAND = "end";
    public static final int MAXIMUM_CODE_VALUE = Integer.MAX_VALUE >> 1;

    private static HashSet<Integer> idSet;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedList<String> objectNames = getInputData(console);

        TreeMap<Integer, String> objectCodeMap = setObjectCode(objectNames);
        System.out.println(objectCodeMap);

        removeRecurrentElement(objectCodeMap);
        System.out.println(objectCodeMap);
    }

    private static LinkedList<String> getInputData(Scanner console) {
        LinkedList<String> objectNames = new LinkedList<>();
        while (console.hasNext()) {
            String objectName = console.nextLine().trim();
            if (!END_INPUT_COMMAND.equalsIgnoreCase(objectName)) {
                objectNames.addLast(objectName);
            } else {
                break;
            }
        }
        return objectNames;
    }

    private static TreeMap<Integer, String> setObjectCode(LinkedList<String> objects) {
        idSet = new HashSet<>(objects.size());
        TreeMap<Integer, String> objectCodeMap = new TreeMap<>();
        for (String object : objects) {
            Integer key = generateUniqueID();
            objectCodeMap.put(key, object);
        }
        return objectCodeMap;
    }

    private static Integer generateUniqueID() {
        while (true) {
            Integer randomCode = ThreadLocalRandom.current().nextInt(0, MAXIMUM_CODE_VALUE);
            if (!idSet.contains(randomCode)) {
                idSet.add(randomCode);
                return randomCode;
            }
        }
    }

    private static void removeRecurrentElement(TreeMap<Integer, String> map) {
        HashSet<String> values = new HashSet<>(map.size());
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            String value = entry.getValue();
            if (values.contains(value)) {
                iterator.remove();
            } else {
                values.add(value);
            }
        }
    }
}



