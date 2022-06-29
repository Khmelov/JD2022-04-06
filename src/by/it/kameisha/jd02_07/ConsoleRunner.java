package by.it.kameisha.jd02_07;

import by.it.kameisha.jd02_07.util.Util;

public class ConsoleRunner {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String path = Util.getPath(ConsoleRunner.class,"playerList"+i+".txt");
            new PlayerGeneratorTask(path).start();
        }
    }
}
