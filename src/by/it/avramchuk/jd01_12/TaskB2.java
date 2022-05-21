package by.it.avramchuk.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {


        List<String> peoples = Arrays.asList("Bob Dylan", "Seryi", "Antony Hopkins", "Elon Musk", "Queen Elizabeth", "Anybody");

        ArrayList<String> arrayList = new ArrayList<>(peoples);
        String winner1 = process (arrayList);
        System.out.println("ArrayList winner: "+ winner1);

        LinkedList<String> linkedList = new LinkedList<>(peoples);
        String winner2 = process (linkedList);
        System.out.println("LinkedList winner: "+ winner2);

    }

    static String process(ArrayList<String> peoples) {
        String winner=peoples.get(0);
        boolean condition = false;
        while(peoples.size()>1) {
            Iterator<String> itr = peoples.iterator();
            if (condition){
                itr.next();
                itr.remove();
            }
            while (itr.hasNext()) {
                winner = itr.next();
                if(itr.hasNext()) {
                    itr.next();
                    itr.remove();
                    condition=false;
                } else condition = true;
            }
        }
        return winner;
    }

    private static String process(LinkedList<String> linkedList) {
        String winner= linkedList.get(0);
        boolean condition = false;
        while(linkedList.size()>1) {
            Iterator<String> itr = linkedList.iterator();
            if (condition){
                itr.next();
                itr.remove();
            }
            while (itr.hasNext()) {
                winner = itr.next();
                if(itr.hasNext()) {
                    itr.next();
                    itr.remove();
                    condition=false;
                } else condition = true;
            }
        }
        return winner;
    }
}
