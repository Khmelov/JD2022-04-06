package by.it.arsenihlaz.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[100];
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2 + 1);
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
        }
        return (index > -1);
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
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
        T[] arrayForAdd = (T[]) c.toArray();
        boolean elementAdded = false;
        for (T elementForAdd : arrayForAdd) {
            if (!this.contains(elementForAdd)) {
                this.add(elementForAdd);
                elementAdded = true;
            }
        }
        return elementAdded;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] arrayForRemove = (T[]) c.toArray();
        boolean elementRemoved = false;
        for (T elementForRemove : arrayForRemove) {
            if (this.contains(elementForRemove)) {
                this.remove(elementForRemove);
                elementRemoved = true;
            }
        }
        return elementRemoved;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            out.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        out.append("]");
        return out.toString();
    }

    public T remove(int index) {
        T result = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return result;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    //--------------------------------------------------------------------


    //--------------------------------------------------------------------
    @Override
    public void clear() {
        while (!isEmpty()) {
            elements[size--] = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return elements[currentIndex++];
            }
        };
    }

    @Override
    public Spliterator<T> spliterator() {
        return Set.super.spliterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements,size);
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
