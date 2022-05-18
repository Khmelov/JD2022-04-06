package by.it._tasks_.jd01_13;


import by.it.HomeWork;
import org.junit.Test;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_13_for_calc extends HomeWork {

    @Test(timeout = 1500)
    public void testTaskA__ConsoleRunner() throws Exception {
        run("3.8+26.2\n" +
                "end\n")
                .include("30.0")    //3.8+26.2=30.0
                .exclude("ERROR:"); //9-0.9=8.1 
        run("3.8/0\n" +
                "end\n")
                .include("ERROR:");
        run("5*incorrect_string\n" +
                "end\n")
                .include("ERROR:");

    }

    @Test(timeout = 1500)
    public void testTaskB__ConsoleRunner() throws Exception {
        run("{2,3,4}*2\n" +
                "end\n")
                .include("{4.0, 6.0, 8.0}")    //{2,3,4}*2
                .exclude("ERROR:");
        run("{2,3}+{1,2,3}\n" +
                "end\n")
                .include("ERROR:");
        run("{2,3}-{1,2,3}\n" +
                "end\n")
                .include("ERROR:");
        run("2/{1,2,3}\n" +
                "end\n")
                .include("ERROR:");
    }

    @Test(timeout = 1500)
    public void testTaskC__ConsoleRunner() throws Exception {
        run("{{1,2},{8,3}}-{{2,3,3},{2,3,3}}\n" +
                "{{1,2},{8,3}}*{{1,2},{8,3}}\n" +
                "end\n")
                .include("ERROR:")
                .include("{{17.0, 8.0}, {32.0, 25.0}}") //{{1,2},{8,3}} * {{1,2},{8,3}}
        ;
    }


}
