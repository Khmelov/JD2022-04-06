package by.it.avramchuk.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 1; i<=4096; i++){
            arrayList.add("n"+i);
            linkedList.add("n"+i);
        }
        Timer t = new Timer();

        System.out.println(process(arrayList)+ " ArrayList отработал за "+t);
        System.out.println(process(linkedList)+ " LinkedList отработал за "+t);



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
    public static class Timer{
        private  long iniTime;
        private Double Delta;
        public Timer() {iniTime = System.nanoTime();}
        public String toString() {
            Delta=(double) (System.nanoTime()-iniTime)/1000;
            iniTime = System.nanoTime();
            return Delta.toString()+" микросекунд.";
        }
    }
}
