package by.it.marchenko.jd01_11;

import java.util.*;


@SuppressWarnings({"unchecked", "ConstantConditions"})
public class ListA<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 10;
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";


    private static int capacity = 0;
    private E[] elements = (E[]) new Object[INITIAL_CAPACITY];


    @Override
    public String toString() {
        StringJoiner outString = new StringJoiner(DELIMITER, PREFIX, SUFFIX);
        for (int i = 0; i < capacity; i++) {
            outString.add(elements[i].toString());
        }
        return outString.toString();
    }

    @Override
    public boolean add(E e) {
        if (capacity == elements.length) {
            elements = Arrays.copyOf(elements, (int) (capacity * 1.5) + 1);
        }
        elements[capacity++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        E elementForRemove = elements[index];
        System.arraycopy(elements,
                index + 1,
                elements,
                index,
                --capacity - index);
        elements[capacity] = null;
        return elementForRemove;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public int size() {
        return capacity;
    }

    //TODO recent interfaces
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
        return null;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
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
    public boolean remove(Object o) {
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

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
