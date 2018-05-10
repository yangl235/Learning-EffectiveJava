package ch5.num21;

import java.io.ObjectStreamException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 第21条 用类来代替enum结构
 * 在Java中使用类型安全枚举是比较好的选择
 */
public class Suit {
    private final String name;

    /**
     * Ordinal of next suit to be created
     */
    private static int nextOrdinal = 0;

    /**
     * Assign an ordinal to this suit
     */
    private final int ordinal = nextOrdinal++;

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int compareTo(Object o) {
        return ordinal - ((Suit) o).ordinal;
    }

    public static final Suit CLUBS = new Suit("clubs");
    public static final Suit DIAMONDS = new Suit("diamonds");
    public static final Suit HEARTS = new Suit("hearts");
    public static final Suit SPADES = new Suit("spades");

    /**
     * 可以将常量放到集合中
     */
    private static final Suit[] PRIVATE_VALUES = {CLUBS, DIAMONDS, HEARTS, SPADES};
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    /**
     * 要实现集合的序列化，除了在类的声明中implements Serializable之外，还必须提供一个readResolve方法
     *
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return PRIVATE_VALUES[ordinal];
    }


}
