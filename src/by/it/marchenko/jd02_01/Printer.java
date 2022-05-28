package by.it.marchenko.jd02_01;

import java.io.PrintStream;

public class Printer extends PrintStream {
    private static PrintStream out;

    public Printer(PrintStream out) {
        super(out);
        //this.out = out;
    }
}
