package by.it.marchenko.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] peoples = getInputData(console);

        ArrayList<String> peoplesArrayList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinkedList = new LinkedList<>(Arrays.asList(peoples));

        System.out.printf("ArrayList winner  : %s", process(peoplesArrayList));
        System.out.printf("LinkedList winner : %s", process(peoplesLinkedList));
    }

    private static String[] getInputData(Scanner input) {
        System.out.print("Enter peoples amount: ");
        int peopleAmount = input.nextInt();
        String[] peopleNames = new String[peopleAmount];
        for (int i = 0; i < peopleNames.length; i++) {
            peopleNames[i] = input.next();
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
}
