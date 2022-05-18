package by.it.kadulin.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {
    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[10];

    private int size = 0;

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3/2 + 1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {
        E result = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return result;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E element) {

        E result = elements[index];
        elements[index] = element;
        return result;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                sj.add("null");
            }
            else
            sj.add(elements[i].toString());
        }
        return sj.toString();
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3/2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Iterator<? extends E> iterator = c.iterator();
        while (iterator.hasNext()) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3/2 + 1);
            }
            elements[size] = iterator.next();
            size++;
        }
        return true;
    }

    //------------------------------

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
        return new Iterator<>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex<size;
            }

            @Override
            public E next() {
                return elements[currentIndex++];
            }
        };
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
    public boolean addAll(int index, Collection<? extends E> c) {
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
