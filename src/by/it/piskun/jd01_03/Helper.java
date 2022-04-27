package by.it.piskun.jd01_03;

public class Helper {
    static double findMin(double[] array){
        double min= array[0];
        for (int i = 0; i < array.length; i++) {
           if (array[i]<min) {
               min = array[i];
           }
           }
        System.out.println("Min="+min);
        return min;
    }



    static double findMax(double[] array) {
        double max=array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i]>max){
                max=array[i];
            }
        }
        System.out.println("max="+max);
        return max;
    }

    static void sort(double[] array) {
        /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
            for (int i = 0; i < array.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
                double min = array[i];
                int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
                for (int j = i+1; j < array.length; j++) {
                    //Если находим, запоминаем его индекс
                    if (array[j] < min) {
                        min = array[j];
                        min_i = j;
                    }
                }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
                if (i != min_i) {
                    double tmp = array[i];
                    array[i] = array[min_i];
                    array[min_i] = tmp;
                }
            }
        }
    }
