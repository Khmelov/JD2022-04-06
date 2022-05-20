package by.it.kadulin.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[10];

    private int size = 0;

    @Override
    public boolean add(E e) {
        boolean coincidences = false;
        for (int i = 0; i < size; i++) {
            if (e == elements[i]) {
                coincidences = true;
            }
        }
        if (!coincidences) {
            if (e == null) {
                return false;
            }
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size] = e;
            size++;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator<? extends E> iterator = c.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            boolean isFind = false;
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    if (elements[i] == next) {
                        isFind = true;
                        break;
                    }
                }
                else if (elements[i].equals(next)) {
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                if (size == elements.length) {
                    elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
                }
                elements[size] = (E) next;
                size++;
                count++;
            }
        }
        return count > 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == elements[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        int coincidences = 0;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            for (int i = 0; i < size; i++) {
                if (next == null) {
                    if (next == elements[i]) {
                        coincidences++;
                        break;
                    }
                } else if (next.equals(elements[i])) {
                    coincidences++;
                    break;
                }
            }
        }
        return c.size() == coincidences;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == elements[i]) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Object next = iterator.next();
            for (int i = 0; i < size; i++) {
                if (next == elements[i]) {
                    System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                    size--;
                    count++;
                    break;
                }
            }
        }
        return count > 0;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                return elements[currentIndex++];
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                sj.add("null");
            } else
                sj.add(elements[i].toString());
        }
        return sj.toString();
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
