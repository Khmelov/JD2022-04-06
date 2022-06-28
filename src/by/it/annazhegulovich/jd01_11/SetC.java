package by.it.annazhegulovich.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[10];
    private int size = 0;

    @Override
    public String toString() {
        StringJoiner SetArr = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                SetArr.add(elements[i].toString());
            } else {
                SetArr.add("null");
            }
        }
        return SetArr.toString();
    }

    @Override
    public boolean add(T e) {
        if (elements.equals(e)){
            return false;
        } else{
            if (size==elements.length){
                elements= Arrays.copyOf(elements, elements.length*3/2+1);
            }
            elements[size++]=e;
            return true;
        }
    }

    @Override
    public  boolean contains(Object o) {
        return (elements.equals(o));
    }

    @Override
    public boolean remove(Object o) {
       /* int a;
        if (o==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null){
                    a= i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])){
                    a= i;
                }
            }
        }
        a= -1;

        if (a>-1){
            remove(a);
        }
        return (a>-1);*/
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

   /*

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index>-1){
            remove(index);
        }
        return (index>-1);
    }

    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null){
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public T get(int index) {
        return elements[index];
    }

//Stabs------------------------------------------------------------------------------------------
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }*/
    //-----------------------------------------------------------------------------------------------------






}