package by.it.kameisha.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[10];
    private int size = 0;

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (null != elements[i]) {
                out.add(elements[i].toString());
            } else {
                out.add("null");
            }
        }
        return out.toString();
    }

    @Override
    public boolean add(T t) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(t)) return false;
        }
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] objects = (T[]) c.toArray();
        boolean check = false;
        System.out.println(objects);
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < size; j++) {
                if (null!=elements[j] && elements[j].equals(objects[i])) {
                    break;
                }
            }
            check =true;
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size] = objects[i];
            size++;
        }
        return check;
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

    @Override
    public void clear() {

    }
}
