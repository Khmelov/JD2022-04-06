package by.it._classwork_.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {
    public static final int INITIAL_LENGTH = 10;
    public static final double CAPACITY_INCREMENT = 1.5;

    public static final String TO_STRING_DELIMITER = ", ";
    public static final String TO_STRING_PREFIX = "[";
    public static final String TO_STRING_SUFFIX = "]";

    private int capacity = 0;
    private E[] elements = (E[]) new Object[INITIAL_LENGTH];


    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(TO_STRING_DELIMITER, TO_STRING_PREFIX, TO_STRING_SUFFIX);
        for (int i = 0; i < capacity; i++) {
            if (elements[i] != null) {
                out.add(elements[i].toString());
            } else {
                out.add("null");
            }

        }
        return out.toString();
    }

    @Override
    public boolean add(E e) {
        if (capacity == elements.length) {
            elements = Arrays.copyOf(elements, (int) (capacity * CAPACITY_INCREMENT + 1));
        }
        elements[capacity++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E elementToRemove = elements[index];
        System.arraycopy(elements, index + 1, elements, index, --capacity - index);
        elements[capacity] = null;
        return elementToRemove;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < capacity) {
            E returnElement = elements[index];
            elements[index] = element;
            return returnElement;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (capacity == elements.length) {
            elements = Arrays.copyOf(elements, (int) (capacity * CAPACITY_INCREMENT + 1));
        }
        System.arraycopy(elements, index, elements, index + 1, capacity - index);
        capacity++;
        elements[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        while (capacity + c.size() >= elements.length) {
            elements = Arrays.copyOf(elements, (int) (elements.length * CAPACITY_INCREMENT + 1));
        }
        E[] arrayToAdd = (E[]) c.toArray();
        elements = Arrays.copyOf(elements, capacity + arrayToAdd.length);
        System.arraycopy(arrayToAdd, 0, elements, capacity, arrayToAdd.length);
        capacity += arrayToAdd.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > capacity) {
            return false;
        }
        while (capacity + c.size() >= elements.length) {
            elements = Arrays.copyOf(elements, (int) (elements.length * CAPACITY_INCREMENT + 1));
        }
        E[] arrayToAdd = (E[]) c.toArray();
        System.arraycopy(elements, index, elements, index + arrayToAdd.length, capacity - index);
        System.arraycopy(arrayToAdd, 0, elements, index, arrayToAdd.length);
        capacity += arrayToAdd.length;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < capacity;
            }

            @Override
            public E next() {
                return elements[currentPosition++];
            }
        };
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean contains(Object o) {
        E elementForSearch = (E) o;
        for (E element : elements) {
            if ((elementForSearch == null && element == null) ||
                    (element != null && element.equals(elementForSearch))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, capacity);
    }

    @Override
    public int indexOf(Object o) {
        E elementForSearch = (E) o;
        for (int i = 0; i < capacity; i++) {
            if ((elementForSearch == null && elements[i] == null) ||
                    (elements[i] != null && elements[i].equals(elementForSearch))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object o) {
        E elementForRemove = (E) o;
        int index = this.indexOf(elementForRemove);
        if (index < 0) {
            return false;
        } else {
            this.remove(index);
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
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
