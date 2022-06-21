package by.it._examples_.jd02_03;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolDemo {

    public static void main(String[] args) {
        int maxSize = 1000;
        int low = 0;
        int max = 400;
        int[] arr = new Random()
                .ints(low, max)
                .limit(maxSize)
                .toArray();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MergeSort mergeSort = new MergeSort(arr);
        arr = forkJoinPool.invoke(mergeSort);
        System.out.println(Arrays.toString(arr));
    }

}

class MergeSort extends RecursiveTask<int[]> {
    private final int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    @Override
    protected int[] compute() {
        if (array.length > 1) {
            //split
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);
            //recursion
            MergeSort leftTask = new MergeSort(left);
            MergeSort rightTask = new MergeSort(right);
            leftTask.fork();  //у FJP внутри LIFO
            rightTask.fork(); //поэтому
            right = rightTask.join(); //join нужен после fork
            left = leftTask.join(); //причем в обратном порядке
            //merge
            for (int i = 0, il = 0, jr = 0; i < array.length; i++) {
                array[i] = jr == right.length || (il < left.length && left[il] < right[jr])
                        ? left[il++]
                        : right[jr++];
            }
        }
        return array;
    } //compute
}
