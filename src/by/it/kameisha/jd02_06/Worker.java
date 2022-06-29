package by.it.kameisha.jd02_06;

public class Worker extends Thread {
    public Worker(String name) {
        super(name);
    }

    @Override
    public void run() {
        Logger.getInstance().log(this.getName());
    }
}
