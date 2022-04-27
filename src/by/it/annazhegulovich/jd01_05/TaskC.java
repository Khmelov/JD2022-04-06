package by.it.annazhegulovich.jd01_05;

import static java.lang.Math.pow;

public class TaskC {

        public static void main(String[] args) {
            step1();
            //step2();
        }

        private static void step1() {
            int longArr = (int)(Math.random()*21+20);
            System.out.println(longArr);
            double y = (9-5.33)/(longArr-1);
            double[] arr = new double[longArr];
            System.out.println("Массив arr:");
            int k=0;
            for (double x = 5.33; x <=9 ; x=x+y) {
                    double z = pow((pow(x,2)+4.5),1.0/3);
                    arr[k] = z;
                    System.out.printf("Arr[% 4d ]=%-12.5f%n",k,z);
                k++;
                }
            double [] new_arr = new double[longArr];
            System.out.println("Массив new_arr:");
            int i=0;

            for ( k = 0; k < longArr; k++) {

            if (arr[k]>3.5){
                new_arr [i] = arr [k];
                System.out.printf("new_arr[% 4d ]=%-12.5f%n",i,arr[k]);
                i++;
            }
            }

double m = 0;

                for (i = 0; i <new_arr.length ; i++) {
                    m=m*new_arr[i];
                }
            double mg =pow(m, 1.000000/new_arr.length);
                System.out.println("Среднее геометрическое = "+mg);
        }
        }
