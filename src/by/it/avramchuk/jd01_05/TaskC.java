package by.it.avramchuk.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        double start = 5.33;
        double stop = 9.0;
        int n = ((int) (Math.random()*21))+20;
        double step = (stop-start)/(n-1);

        double[] array = new double[n];
        int index =0;
        int counter = 0;
        System.out.println("Массив М:");
        for(double x = start; x<=stop; x= x+step){
            array[index] = Math.cbrt((x*x)+4.5);
            System.out.printf(" M[%2d]=%8.5f", index, array[index]);
            if (array[index]>3.5){
                counter++;
            }
            index++;
            if(index%5==0){
                System.out.println();
            }
        }

        double [] miniArray= new double[counter];
        index = 0;
        for (double element:array){
            if(element>3.5){
                miniArray[index] = element;
                index++;
            }
        }

        double pr = 1.0;
        double average;

        for(double element: miniArray){
            pr = pr*element;
        }
        average = Math.pow(pr, 1.0/miniArray.length);
        System.out.println("Average = "+average);

    }
}
