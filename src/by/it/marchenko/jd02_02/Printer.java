package by.it.marchenko.jd02_02;

import java.io.PrintStream;

public class Printer extends PrintStream {

    public Printer(PrintStream out) {
        super(out);
    }

    public Printer() {
        super(System.out);
    }
}
