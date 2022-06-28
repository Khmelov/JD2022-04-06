package by.it.kadulin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        fillLists(linkedList, arrayList, 16);
        System.out.println(process(linkedList));
        System.out.println(process(arrayList));
    }

    private static String process(LinkedList<String> linkedList) {
        String result = "";
        boolean isLast = linkedListKillSomeoneWithSecondIndex(linkedList);
        while (linkedList.size() != 1) {
            if (isLast) {
                isLast = linkedListKillSomeoneWithSecondIndex(linkedList);
            } else if (!isLast) {
                isLast = linkedListKillSomeoneWithFirstIndex(linkedList);
            }
        }
        result = linkedList.get(0);
        return result;
    }

    private static boolean linkedListKillSomeoneWithFirstIndex(List<String> linkedList) {
        Iterator<String> iteratorLinkedList = linkedList.iterator();
        int sizeList = linkedList.size();
        int count = 1;
        int indexOfLastKill = 0;
        boolean lastIndexOfKill = false;
        while (iteratorLinkedList.hasNext()) {
            String next = iteratorLinkedList.next();
            if (count % 2 == 1) {
                iteratorLinkedList.remove();
                indexOfLastKill = count;
                count++;

            } else {
                count++;
                continue;
            }
        }
        if (sizeList == indexOfLastKill) {
            lastIndexOfKill = true;
        } else if ((sizeList - 1) == indexOfLastKill) {
            lastIndexOfKill = false;
        }
        return lastIndexOfKill;
    }

    private static boolean linkedListKillSomeoneWithSecondIndex(List<String> linkedList) {
        Iterator<String> iteratorLinkedList = linkedList.iterator();
        int sizeList = linkedList.size();
        int count = 0;
        int indexOfLastKill = 0;
        boolean lastIndexOfKill = false;
        while (iteratorLinkedList.hasNext()) {
            String next = iteratorLinkedList.next();
            if (count % 2 == 0) {
                count++;
                continue;
            } else if (count % 2 == 1) {
                iteratorLinkedList.remove();
                indexOfLastKill = count;
                count++;
            }
        }
        if ((sizeList - 1) == indexOfLastKill) {
            lastIndexOfKill = true;
        } else if ((sizeList - 2) == indexOfLastKill) {
            lastIndexOfKill = false;
        }
        return lastIndexOfKill;
    }

    private static String process(ArrayList<String> arrayList) {
        String result = "";
        boolean isLast = linkedListKillSomeoneWithSecondIndex(arrayList);
        while (arrayList.size() != 1) {
            if (isLast) {
                isLast = linkedListKillSomeoneWithSecondIndex(arrayList);
            } else if (!isLast) {
                isLast = linkedListKillSomeoneWithFirstIndex(arrayList);
            }
        }
        result = arrayList.get(0);
        return result;
    }

    private static void fillLists(LinkedList<String> linkedList, ArrayList<String> arrayList, int count) {
        for (int i = 0; i < count; i++) {
            String member = "mem" + i;
            linkedList.add(member);
            arrayList.add(member);
        }
    }
}
