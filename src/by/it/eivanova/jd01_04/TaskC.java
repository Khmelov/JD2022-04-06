package by.it.eivanova.jd01_04;

import by.it.eivanova.jd01_03.Helper;
import by.it.eivanova.jd01_03.InOut;

import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Scanner;


public class TaskC {

    private static InOut inOut;
    private static OptionalDataException arr;
    private static double elementToSearch;
    private static double[] assist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }


    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        // Helper.sort(array);
        //inOut.printArray(array, "V", 4);
    }


    static void mergeSort(double[] array) {
        int low = 0;
        int high = array.length - 1;
        mergeSort(array, low, high);
    }



    private static void mergeSort(double[] array, int low, int high) {
        if(low>=high)
            return;
        // Разделите элементы низкого до высоты на две группы
        int mid= (low+high)/2;

        // сортировать каждую группу соответственно
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
    }

    private static void exchange(double a[],int i,int j){
        double temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    // Журнал до середины в массиве - это группа, а середина + 1 на высокий бит устанавливается, а две группы данных возвращаются.
    private static void  merge(double a[],int low,int mid,int high){

        // Определите три указателя
        int i=low;
        int p1=low;
        int p2=mid+1;

        // Проверьте, переместите указатель P1, P2, сравните соответствующее значение, найдите маленький, поместите его в вспомогательный ассистерт [], пока один из указателей не закончил
        while (p1<=mid && p2<=high){
            //Сравнивать
            if(a[p1]<=a[p2]){
                assist[i++]=a[p1++];
            }
            else {
                assist[i++]=a[p2++];
            }
        }

        // следующее, когда петли будут выполняться только
        // Trowerse, если указатель P1 не закончен, то переместите указатель P1 последовательно, переместите соответствующий элемент в указанный массив.
        while (p1<=mid){
            assist[i++]=a[p1++];
        }
        // Пройдите, если указатель P2 не закончен, то переместите указатель P2, переместите соответствующий элемент в указанный массив.
        while (p2<=high){
            assist[i++]=a[p2++];
        }

        // Скопируйте вспомогательный массив в оригинальную группу номер
        for (int j=low;j<=high;j++){
            a[j]=assist[j];
        }
    }


}