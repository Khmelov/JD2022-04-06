package by.it.kudelko.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private E[] array =  (E[]) new Object[10];

    private int size = 0;

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
    public boolean add(E e) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, array.length*3/2 + 1);
        }
        array[size] = e;
        size++;
        return true;
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
    public boolean addAll(Collection<? extends E> c) {
        if (size <= array.length - 1 + c.size()) {
            array = Arrays.copyOf(array, array.length*3/2 + c.size());
        }
        int index = size;
        for (E e : c) {
            array[index] = e;
            index++;
        }
        size = size + c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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
    public int indexOf(Object o) {
        return 0;
    }

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
