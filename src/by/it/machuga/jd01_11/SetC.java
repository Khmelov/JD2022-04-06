package by.it.machuga.jd01_11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private HashMap<T,Object> elements =  new HashMap<>();
    private final Object VALUE=new Object();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimiter = "";
        for (T element : elements.keySet()) {
            stringBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean add(T t) {
        return elements.put(t,VALUE)==VALUE;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o)==VALUE;
    }

    @Override
    public boolean contains(Object o) {
        return elements.containsKey(o);
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
        return elements.keySet().containsAll(c);
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

    //------------------------------------

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
