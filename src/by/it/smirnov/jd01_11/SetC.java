package by.it.smirnov.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private boolean reallyContains(Object o) {
        for (int i = 0; i < size; i++) {
            if (map[i] == o) return true;
        }
        return false;
    }

    private E[] map = (E[]) new Object[10];
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(map[i]);
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

        return reallyContains(o);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return map[index++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[map.length];
        System.arraycopy(map, 0, copy, 0, map.length);
        return copy;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
/*
    @Override
    public <T> T[] toArray(T[] a) {
        T[] arrayOut = (T[]) new Object[size];
        int index = 0;
        for (Object o :
                map.keySet()) {
            arrayOut[index] = (T)o;
            index++;
        }
        return arrayOut;
    }

 */

    @Override
    public boolean add(E e) {

        if (!reallyContains(e)) {
            if (size == map.length - 1) {
                map = Arrays.copyOf(map, map.length * 3 / 2 + 1);
            }
            map[size] = e;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (map[i].equals(o)) {
                System.arraycopy(map, i + 1, map, i, size - i - 1);
                map[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        E[] array = (E[]) c.toArray();
        for (int i = 0; i < array.length; i++) {
            if (!reallyContains(array[i])) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        E[] array = (E[]) c.toArray();
        int initialSize = size;
        for (int i = 0; i < array.length; i++) {
            if (add(array[i])) modified = true;
            /*if (size == map.length - 1) {
                map = Arrays.copyOf(map, map.length * 3 / 2 + 1);
            }
            if (!reallyContains((Object) array[i])) {
                map[size] = array[i];
                size++;
            }

             */
        }
        //if (initialSize < size) return true;
        //return false;
        return modified;

        //boolean modified = false;
        //for (T e : c)
        //    if (add(e))
        //        modified = true;
        //return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        E[] copy = (E[]) new Object[map.length];
        System.arraycopy(map, 0, copy, 0, map.length);
        int copysize = size;
        int koef = 0;
        E[] array = (E[]) c.toArray();
        for (int i = 0; i < copysize; i++) {
            for (int j = 0; j < array.length; j++) {
                if (copy[i] == (array[j])) {
                    System.arraycopy(map, i-koef + 1, map, i-koef, size - i - 1);
                    size--;
                    koef++;
                }
                if (size < copysize) return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        map = (E[]) new Object[10];
        size = 0;
    }
}
