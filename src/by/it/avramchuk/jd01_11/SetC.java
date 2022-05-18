package by.it.avramchuk.jd01_11;

import java.util.*;

public class SetC<E>  implements Set<E> {

    private List<E> set = new ListB<E>();



    @Override
    public boolean add(E e) {
        if (set.contains(e)){
            return false;
        } else {
            set.add(e);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        } else if(set.indexOf((E)o) >=0) {
          set.remove( set.indexOf((E) o));
          return true;
        } else {return false;}
    }

    @Override
    public boolean contains(Object o) {
        if(set.contains(o)){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] collection = c.toArray();
        int counter = set.size();
        for (Object o : collection) {
           this.add((E) o);
        }
        if (counter == set.size()) {
            return false;
        } else {return true;}
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] collection = c.toArray();
        int counter = 0;
        for (Object o : collection) {
            if (contains((E) o)){
                counter++;
            }
        }
        if (counter==collection.length) {
            return true;
        } else return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] collection = c.toArray();
        int counter = size();
        for (Object o : collection) {
            this.remove((E) o);
        }
        if (counter==size()){
            return false;
        } else {return true;}
    }

    @Override
    public String toString() {
        return set.toString();
    }

    //Stubs

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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        set.clear();
    }
}
