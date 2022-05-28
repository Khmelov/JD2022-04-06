package by.it.marchenko.jd02_01;

import java.io.PrintStream;

public class Printer extends PrintStream {
    //private PrintStream out;

    public Printer(PrintStream out) {
        //    this.out=out;
        super(out);
    }

    public Printer() {
        //   this.out=System.out;
        super(System.out);
        System.out.println();
    }
}
