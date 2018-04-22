package ch4;

import java.util.Map;

public abstract class AbstractMapEntry implements Map.Entry {
    //primitives

    /**
     * @return
     */
    public abstract Object getKey();

    /**
     * @return
     */
    public abstract Object getValue();

    /**
     * Entries in modifiable maps must override this method
     *
     * @param value
     * @return
     */
    public Object setValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry arg = (Map.Entry) o;
        return eq(getKey(), arg.getKey()) && eq(getValue(), arg.getValue());
    }

    private static boolean eq(Object o1, Object o2) {
        return (o1 == null ? o2 == null : o1.equals(o2));
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() == null ? 0 : getValue().hashCode());
    }


}
