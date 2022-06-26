package by.it.marchenko.calc.exception;

public class CalcExceptionHandler {
    public void handleCalcException(CalcException e) {
        String message = e.getMessage();
        System.out.println(message);
    }
}
