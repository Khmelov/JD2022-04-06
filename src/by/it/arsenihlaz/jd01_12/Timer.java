package by.it.arsenihlaz.jd01_12;

public class Timer{
        private  long iniTime;

        public Timer(){
            iniTime= System.nanoTime();
        }
        public String toString(){
            double delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime= System.nanoTime();

            return "Прошло "+ delta +" микросекунд.";
        }

    }