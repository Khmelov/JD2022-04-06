package by.it.marchenko.jd02_07;

import java.util.Set;

public class Tester {
    public static void main(String[] args) {
        PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask();
        String stream1 = playerGeneratorTask.taskStream("myStream1");

        System.out.println(stream1);
        PlayerReaderTask playerReaderTask = new PlayerReaderTask();
        Set<Player> fromFile = playerReaderTask.createFromFile(stream1);
        System.out.println(fromFile);

    }
}
