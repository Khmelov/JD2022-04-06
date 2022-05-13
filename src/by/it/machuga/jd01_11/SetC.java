package by.it.machuga.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private List<T> elements = new ListB<T>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < elements.size(); i++) {
            stringBuilder.append(delimiter).append(elements.get(i));
            delimiter = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean add(T t) {
        if (!contains(t)) {
            return elements.add(t);
        }
        return false;
    }


    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element : c) {
            elements.remove(element);
        }
        return true;
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
