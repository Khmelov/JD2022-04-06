package by.it.marchenko.jd01_11;

import java.util.*;


public class SetC<E> implements Set<E> {
    private static final int INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.25d;

    public static final String TO_STRING_DELIMITER = ", ";
    public static final String TO_STRING_PREFIX = "[";
    public static final String TO_STRING_SUFFIX = "]";

    private E[] elements = (E[]) new Object[INITIAL_CAPACITY];
    private int size = 0;

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(TO_STRING_DELIMITER, TO_STRING_PREFIX, TO_STRING_SUFFIX);
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                out.add(elements[i].toString());
            } else {
                out.add("null");
            }

        }
        return out.toString();
    }

    @Override
    public boolean contains(Object o) {
        E elementForSearch = (E) o;
        for (E element : elements) {
            if ((element == null && elementForSearch == null) ||
                    (element != null && element.equals(elementForSearch))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e)) {
            return false;
        } else {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, (int) (elements.length * (1 + LOAD_FACTOR)));
            }
            elements[size++] = e;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        E e = (E) o;
        if (this.contains(o)) {
            for (int i = 0; i < size; i++) {
                if ((elements[i] == null && e == null) ||
                        (elements[i] != null && elements[i].equals(e))) {
                    System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                    elements[size--] = null;
                    break;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] arrayForAdd = (E[]) c.toArray();
        boolean elementAdded = false;
        for (int i = 0; i < arrayForAdd.length; i++) {
            if (!this.contains(arrayForAdd[i])) {
                this.add(arrayForAdd[i]);
                elementAdded = true;
            }
        }
        return elementAdded;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        E[] arrayForAdd = (E[]) c.toArray();
        for (int i = 0; i < arrayForAdd.length; i++) {
            if (!this.contains(arrayForAdd[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator() {
            int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < size;
            }

            @Override
            public Object next() {
                return elements[currentPosition++];
            }
        };
    }

    @Override
    public Object[] toArray() {

        return Arrays.copyOf(elements, size);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        E[] arrayForRemove = (E[]) c.toArray();
        boolean elementRemoved = false;
        for (int i = 0; i < arrayForRemove.length; i++) {
            if (this.contains(arrayForRemove[i])) {
                this.remove(arrayForRemove[i]);
                elementRemoved = true;
            }
        }
        return elementRemoved;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            elements[size--] = null;
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
