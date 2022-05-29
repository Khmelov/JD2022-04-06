package by.it.ragach.calc;

public class CalcExeption extends Exception{

    public CalcExeption(String message){
        super(message);
    }
    public CalcExeption(String format, Object...parameters){
        this(String.format(format,parameters));

    }
}
