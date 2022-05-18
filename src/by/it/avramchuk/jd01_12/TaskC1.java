package by.it.avramchuk.jd01_12;

import java.util.*;

public class TaskC1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str= "";
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            if (input.equals("end")){
                break;
            } else {
                str = str+input+" ";
            }
        }

        String[] split = str.split("[^a-zA-Z']+");
        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            map.put(i, split[i]);
        }
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println(entries);
        HashMap<Integer, String> newMap = new HashMap<>();

        Set<String> setValues = new HashSet<>(map.values());
        System.out.println(setValues);
        Iterator<String> itr = setValues.iterator();
        while (itr.hasNext()){
           String next= itr.next();
        }

        System.out.println(entries);
        System.out.println(setValues);


    }
}
