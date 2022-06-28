package by.it.avramchuk.jd01_12;

import java.sql.SQLOutput;
import java.util.*;

public class TaskB1 {
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
        List<String> asList = Arrays.asList(split);
        ArrayList<String> list  = new ArrayList<>(asList);
        HashMap<String, Integer> map = new HashMap<>();


        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String next = itr.next();
           if(map.putIfAbsent(next, 1)!=null){
               int i = map.putIfAbsent(next, 1);
               map.put(next, ++i);
            }

            }
          System.out.println(map.entrySet());
        }

    }

