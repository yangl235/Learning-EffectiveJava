package ch4;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


/**
 * Typical use of nonstatic member class
 */
public class MySet extends AbstractSet {
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator {

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            return null;
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        //Typical use of an anonymous class
        Arrays.sort(args, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o1.length() - o2.length());
            }
        });
    }
}
