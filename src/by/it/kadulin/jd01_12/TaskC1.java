package by.it.kadulin.jd01_12;

import java.util.*;

public class TaskC1 {

    static TreeMap<String, String> map = new TreeMap<>();
    static HashSet<String> values = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            String str = sc.nextLine();
            if (str.equals("end")) {
                break;
            }
//            map.put(UUID.randomUUID().toString(), str);
            map.put(String.valueOf(count++), str);
        }
        System.out.println();

        System.out.println(map.toString());
        System.out.println();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            String value = iterator.next().getValue();
            if (!values.contains(value)) {
                values.add(value);
            }
            else {
                iterator.remove();
            }
        }
        System.out.println(map.toString());
    }
}
