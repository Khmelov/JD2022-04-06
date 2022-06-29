package by.it.arsenihlaz.jd02_07;

import by.it.arsenihlaz.jd02_07.service.PlayerGeneratorTask;

public class Runner {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            PlayerGeneratorTask playerGeneratorTask = new PlayerGeneratorTask();
            playerGeneratorTask.start();
        }

    }
}
