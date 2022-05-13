package by.it.avramchuk.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private  E[] elements = (E[]) new Object[10];
    private  int size = 0;

    @Override
    public boolean add(E e) {
        if (size==elements.length){
            elements = Arrays.copyOf(elements, elements.length*3/2+1);
        }
        elements[size] = e;
        size++;
        return true;
    }

    @Override
    public E remove(int index) {

        E result = elements[index];
        System.arraycopy(elements, index+1,elements, index, size-index-1);
        elements[--size]=null;
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
        elements[index]= element;
        return result;
    }

    @Override
    public void add(int index, E element) {
        //                                 size
        // 0     1      2     3     4      5     6      7
        //one    two    thre  four  five   null

        if (size==elements.length){
            elements = Arrays.copyOf(elements, elements.length*3/2+1);
        }
        System.arraycopy(elements, index,elements, index+1, size-index);
        elements[index]=element;
        size++;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] collection = c.toArray();
        if (collection.length==0){
            return false;
        }

        for (int i = 0; i < collection.length ; i++) {
            if (size==elements.length){
                elements = Arrays.copyOf(elements, elements.length*3/2+1);
            }
            elements[size] = (E) collection[i];
            size++;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] collection = c.toArray();
        if (collection.length==0){
            return false;
        }

        for (int i = 0; i < collection.length; i++) {
            if (size==elements.length){
                elements = Arrays.copyOf(elements, elements.length*3/2+1);
            }
            System.arraycopy(elements, index,elements, index+1, size-index);
            elements[index]= (E) collection[i];
            size++;
            index++;
        }

        return  true;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (Objects.nonNull(elements[i])){
                out.add(elements[i].toString());
            } else {
                out.add("null");
            }
        }
        return out.toString();

    }

    // Stubs

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
    public boolean remove(Object o) {
        return false;
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
