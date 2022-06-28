package by.it.edeborg.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] peoples = getNames(scanner);

        ArrayList<String> peoplesArray = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> peoplesLinked = new LinkedList<>(Arrays.asList(peoples));

        System.out.println("ArrayList winner " + process(peoplesArray));
        System.out.println("LinkedList winner " +  process(peoplesLinked));


    }

    private static String[] getNames(Scanner scanner)
    {
        System.out.println("Введите количество игроков");
        int N = scanner.nextInt();
        String[] names = new String[N];
        for (int i = 0; i < names.length; i++)
        {
            names[i] = scanner.next();

        }
        return names;
    }

    private static String process(LinkedList<String> scannerPeoples) {
        LinkedList<String> peoples = new LinkedList<>(scannerPeoples);
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


    private static String process(ArrayList<String> scannerPeoples) {
        ArrayList<String> peoples = new ArrayList<>(scannerPeoples);
        boolean toRemove = true;
        while (peoples.size() > 1) {
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

    private static String processLinked(LinkedList<String> scannerPeoples) {
        LinkedList<String> peoples = new LinkedList<>(scannerPeoples);
        boolean toRemove = true;
        while (peoples.size() > 1) {
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