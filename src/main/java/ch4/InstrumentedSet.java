package ch4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//使用复合的包装类

public class InstrumentedSet implements Set {
    private Set s = null;
    private int addCount = 0;

    public InstrumentedSet(Set s) {
        this.s = s;
    }

    public int getAddCount() {
        return addCount;
    }


    public int size() {
        return s.size();
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public boolean contains(Object o) {
        return s.contains(o);
    }

    public Iterator iterator() {
        return s.iterator();
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object o) {
        addCount++;
        return s.add(o);
    }

    public boolean remove(Object o) {
        return s.remove(o);
    }

    public boolean addAll(Collection c) {
        addCount += c.size();
        return s.addAll(c);
    }

    public void clear() {
        s.clear();
    }

    public boolean removeAll(Collection c) {
        return s.removeAll(c);
    }

    public boolean retainAll(Collection c) {
        return s.retainAll(c);
    }

    public boolean containsAll(Collection c) {
        return s.containsAll(c);
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public boolean equals(Object o) {
        return s.equals(o);
    }

    public int hashCode() {
        return s.hashCode();
    }

    public String toString() {
        return s.toString();
    }


}
