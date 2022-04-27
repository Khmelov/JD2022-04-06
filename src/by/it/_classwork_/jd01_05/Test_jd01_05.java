package by.it._classwork_.jd01_05;


import by.it.HomeWork;
import org.junit.Test;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_05 extends HomeWork {

    @Test(timeout = 5000)
    public void testTaskA1__TaskA() throws Exception {
        System.out.println("Ожидается -11392.************");
        run("").include("4516");
    }

    @Test(timeout = 5000)
    public void testTaskA2__TaskA() throws Exception {
        System.out.println("Ожидается -3.10***********78");
        run("").include("10653");
    }

    @Test(timeout = 5000)
    public void testTaskA3__TaskA() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a= -5,00 f=17,2**0\n" +
                "При a= -1,25 f=4,3***0\n" +
                "При a=  2,50 f=1,3***7e+13\n" +
                "При a=  6,25 f=6,9***1e+32\n" +
                "При a= 10,00 f=3,5***3e+52\n");
        run("").include("3125");
    }

    @Test(timeout = 5000)
    public void testTaskB1__TaskB() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a=0,00 Сумма y = 6,****48e+00\n" +
                "При a=0,20 Сумма y = 9,****87e+00\n" +
                "При a=0,40 Сумма y = 1,****09e+01\n" +
                "При a=0,60 Сумма y = 1,****22e+01\n" +
                "При a=0,80 Сумма y = 2,****31e+01\n" +
                "При a=1,00 Сумма y = 4,****65e+01\n" +
                "При a=1,20 Сумма y = 6,****12e+01\n" +
                "При a=1,40 Сумма y = 9,****72e+01\n" +
                "При a=1,60 Сумма y = 1,****77e+02\n" +
                "При a=1,80 Сумма y = 1,****33e+02\n" +
                "При a=2,00 Сумма y = 2,****56e+02\n");
        run("").include("2756");
    }

    @Test(timeout = 5000)
    public void testTaskB2__TaskB() throws Exception {
        System.out.println("Ожидается:\n" +
                "При x/2=-2,75 вычисления не определены\n" +
                "При x/2=-2,50 вычисления не определены\n" +
                "При x/2=-2,25 вычисления не определены\n" +
                "При x/2=-2,00 вычисления не определены\n" +
                "При x/2=-1,75 a = 3,****62e-01\n" +
                "При x/2=-1,50 a = 4,****25e-01\n" +
                "При x/2=-1,25 a = 4,****95e-01\n" +
                "При x/2=-1,00 a = 2,****60e-01\n" +
                "При x/2=-0,75 a = 3,****82e-01\n" +
                "При x/2=-0,50 a = 5,****39e-01\n" +
                "При x/2=-0,25 a = 5,****66e-01\n" +
                "При x/2=0,00 a = 5,****16e-01\n" +
                "При x/2=0,25 вычисления не определены\n" +
                "При x/2=0,50 вычисления не определены\n" +
                "При x/2=0,75 вычисления не определены");
        run("").include("8540");
    }

    @Test(timeout = 5000)
    public void testTaskC1__TaskC() throws Exception {
        System.out.println("Ожидается\n" +
                "Массив A[]\n" +
                "A[ 0 ] = 3,****8    A[ 1 ] = 3,**985    A[ 2 ] = 3,29494    A[ 3 ] = 3,33986    A[ 4 ] = 3,38461    \n" +
                "A[ 5 ] = 3,****8    A[ 6 ] = 3,**356    A[ 7 ] = 3,51777    A[ 8 ] = 3,56179    A[ 9 ] = 3,60564    \n" +
                "A[ 10] = 3,****0    A[ 11] = 3,**278    A[ 12] = 3,73608    A[ 13] = 3,77921    A[ 14] = 3,82215    \n" +
                "A[ 15] = 3,****2    A[ 16] = 3,**751    A[ 17] = 3,94993    A[ 18] = 3,99217    A[ 19] = 4,03425    \n" +
                "A[ 20] = 4,****5    A[ 21] = 4,**788    A[ 22] = 4,15945    A[ 23] = 4,20085    A[ 24] = 4,24209    \n" +
                "A[ 25] = 4,****6    A[ 26] = 4,**408    A[ 27] = 4,36483    \n" +
                "\n" +
                "Массив B[] из элементов массива A > 3.5\n" +
                "B[ 0 ] = 3,****7    B[ 1 ] = 3,****9    B[ 2 ] = 3,****4    B[ 3 ] = 3,****0    B[ 4 ] = 3,****8    \n" +
                "B[ 5 ] = 3,****8    B[ 6 ] = 3,****1    B[ 7 ] = 3,****5    B[ 8 ] = 3,****2    B[ 9 ] = 3,****1    \n" +
                "B[ 10] = 3,****3    B[ 11] = 3,****7    B[ 12] = 4,****5    B[ 13] = 4,****5    B[ 14] = 4,****8    \n" +
                "B[ 15] = 4,15945    B[ 16] = 4,20085    B[ 17] = 4,24209    B[ 18] = 4,28316    B[ 19] = 4,32408    \n" +
                "B[ 20] = 4,36483 ");
        run("").include("2045");
    }

    @Test(timeout = 5000)
    public void testTaskC2__TaskC() throws Exception {
        run("")
                .checkCount(2,"╗",2)
                .checkCount(2,"╝",2)
                .checkCount(2,"╔",2)
                .checkCount(2,"╚",2)
                .checkCount(4,"╠")
                .checkCount(4,"╣")
                .checkCount(4,"╦")
                .checkCount(4,"╩")
                .checkCount(4,"╬")
                .checkCount(32,"═")
                .checkCount(32,"\\[")
                .checkCount(32,"]")
                .checkCount(12,"║")
                .checkCount(1,"10")
                .checkCount(1,"11")
                .checkCount(1,"22")
                .checkCount(1,"31")
        ;
    }
}