package by.it.avramchuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array =  step1(sc.nextInt());
        int result = step2(array);
        int [][] newArr  = step3(array);
    }

    public static int[][] step1(int n){

        int[] [] outer = new int[n] [n];

        boolean flag = true;

        while (flag) {
            boolean hasN = false;
            boolean hasNegN = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int random = ((int) (Math.random()* (n*2+1)))-n;
                    outer [i] [j] = random;
                    if (random == n) { hasN = true;}
                    if (random == -n) {hasNegN = true;}
                }
            }
            if (hasN && hasNegN){flag = false;}
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(outer[i] [j] + " ");
            }
            System.out.println();
        }
    return outer;

    }
    public static int step2(int[][] arr){
    int sum = 0;
    int n = arr.length;
        for (int i = 0; i < n; i++) {
        int first = -1;
        int second =-1;
        int counter = 0;
            for (int j = 0; j < n; j++) {
            if (arr[i][j] >0 && counter==0 ) {
                counter++;
                first = j;
            } else if (arr[i][j]>0 && counter!=0) {
                second = j;
                break;
            }
        }
        if (first>=0 && second >= 0) {
            for (int j = first+1; j < second; j++) {
                sum = sum + arr[i][j];
            }
        }
    }
        System.out.println(sum);

        return sum;
    }
    public static int[][] step3(int[][] array){
// Вычисляем размер исходной матрицы
        int size = array[0].length;

//вычисляем макс значение исходной матрицы
        int max=0;
        for(int i = 0; i< size; i++){
            for (int j = 0; j<size; j++){
                if (array[i][j]>max){
                    max = array[i][j];
                }
            }
        }
//вычисляем размер новой матрицы и создаем ее
// а также помечаем флагами все нелегитимные строки и столбцы

        boolean[] legLine = new boolean[size];
        boolean[] legCol = new boolean[size];
        int lines =size;
        int columns =size;
        // по строкам
        for(int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                if (array[i][j]==max){
                    lines--;
                    legLine[i] = true;
                    break;
                }
            }
        }
        // по столбцам
        for(int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){
                if (array[j][i]==max){
                    columns--;
                    legCol[i]=true;
                    break;
                }
            }
        }
        int[][] newArr = new int[lines][columns];

//заполняем одномерный массив легитимными значениями по порядку

        int [] one = new int [lines*columns];
        int index = 0;

        for (int i = 0; i<size; i++){
            for( int j= 0; j<size; j++){
                if (!legLine[i]  && !legCol[j]){
                    one[index] = array[i][j];
                    index++;
                }
            }
        }
//перепаковываем значения по порядку из одномерного массива
//в новую матрицу

        int ind= 0;
        for(int i=0; i<lines; i++){
            for(int j=0; j<columns;j++){
                newArr[i][j] = one[ind];
                ind++;
            }
        }
// возвращаем полученный результат
return newArr;
    }
}
