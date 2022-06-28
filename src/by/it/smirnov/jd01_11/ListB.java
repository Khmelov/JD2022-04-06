package by.it.smirnov.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private E[] array =  (E[]) new Object[10];

    private int size = 0;

    /*@Override
    public String toString() {
        StringJoiner toS = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            toS.add(array[i].toString());
        }
        return toS.toString();
    }

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
           sb.append(delimiter).append(array[i]);
           delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        //Iterator<E> iter = Arrays.stream(array).iterator();
        return new Iterator<E>() {
            private int index;
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public E next() {
                return array[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] copy = Arrays.copyOfRange(array,0, size);
        return copy;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] copy = Arrays.copyOfRange((T[]) array,0, size);
        return copy;
    }

    @Override
    public boolean add(E e) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, array.length*3/2 + 1);
        }
        array[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] arrayFL = (E[]) c.toArray();
        if (size <= array.length - 1 + c.size()) {
            array = Arrays.copyOf(array, array.length*3/2 + c.size());
        }
        int index = size;
        for (int i = 0; i < arrayFL.length; i++) {
            array[index] = arrayFL[i];
            index++;
            size++;
        }

        //size = size + c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E old = array[index];
        array[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, array.length*3/2 + 1);
        }
        System.arraycopy(array, index + 0, array, index+1, size-index);
        array[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E result = array[index];
        System.arraycopy(array, index+1, array, index, size-index-1);
        size--;
        array[size] = null;
        return result;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }


/*
    @Override
    public int indexOf(Object o) {
        E[] array2 = (E[])new Object[]{array};
        Arrays.sort(array2, (Comparator.comparing(Object::toString)));
        return Arrays.binarySearch(array2, o);
    }


 */


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
