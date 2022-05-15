package by.it.marchenko.jd01_12;

import java.util.*;


public class TaskB3 {
    public static final int N = 40960;

    public static void main(String[] args) {
        String[] peoples = getInputData();

        ArrayList<String> peoplesArrayList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedList = new LinkedList<>(Arrays.asList(peoples));
        Timer timer = new Timer();

        String arrayListWinner = process(peoplesArrayList);
        double executionArrayListTime = timer.getMsTime();
        String linkedListWinner = process(peoplesLinkedList);
        double executionLinkedListTime = timer.getMsTime();
        String modifiedLinkedListWinner = modifiedProcess(peoplesLinkedList);
        double executionModifiedLinkedListTime = timer.getMsTime();

        System.out.printf("ArrayList winner          : %s, ExecutionTime: %-4.3f %n",
                arrayListWinner, executionArrayListTime);
        System.out.printf("LinkedList winner         : %s, ExecutionTime: %-4.3f %n",
                linkedListWinner, executionLinkedListTime);
        System.out.printf("ModifiedLinkedList winner : %s, ExecutionTime: %-4.3f %n",
                modifiedLinkedListWinner, executionModifiedLinkedListTime);
    }

    private static String[] getInputData() {
        final String NAME_PREFIX = "n";
        String[] peopleNames = new String[N];
        for (int i = 1; i <= N; i++) {
            peopleNames[i - 1] = NAME_PREFIX.concat(String.valueOf(i));
        }
        return peopleNames;
    }

    static String process(ArrayList<String> inputPeoples) {
        ArrayList<String> peoples = new ArrayList<>(inputPeoples);
        boolean toRemove = true;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                toRemove = !toRemove;
                if (toRemove) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> inputPeoples) {
        LinkedList<String> peoples = new LinkedList<>(inputPeoples);
        boolean toRemove = true;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                toRemove = !toRemove;
                if (toRemove) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    private static String modifiedProcess(LinkedList<String> inputPeoples) {
        LinkedList<String> peoples = new LinkedList<>(inputPeoples);
        boolean toRemove = true;

        while (peoples.size() != 1) {
            toRemove = !toRemove;
            if (toRemove) {
                peoples.removeFirst();
            } else {
                peoples.addLast(peoples.removeFirst());
            }
        }
        return peoples.get(0);
    }
}

