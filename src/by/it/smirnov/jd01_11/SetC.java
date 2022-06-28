package by.it.smirnov.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    HashMap map = new HashMap();
    int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (Object o :
                map.keySet()) {
            sb.append(delimiter).append(o);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
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
        T[] arrayOut = (T[]) new Object[size];
        int index = 0;
        for (Object o :
                map.keySet()) {
            arrayOut[index] = (T)o;
            index++;
        }
        return arrayOut;
    }

    @Override
    public boolean add(E e) {
        if (!map.containsKey(e)) {
            map.put(e, null);
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (map.containsKey(o)) {
            map.remove(o);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!map.containsKey(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            if (!map.containsKey(element)) {
                map.put(element, null);
                size++;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int initialSize = size;
        for (Object o : c) {
            if(map.containsKey(o)) {
                map.remove(o);
                size--;
            }
        }
        return initialSize > size;
    }

    @Override
    public void clear() {
        map.clear();
        size = 0;
    }
}

