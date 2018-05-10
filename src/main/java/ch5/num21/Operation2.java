package ch5.num21;

import java.io.ObjectStreamException;

/**
 * 外部调用Operation时，以Operation常量作为参数，Operation类本身是一个抽象类，只包含
 * 一个包级私有方法eval(),针对每个常量都定义一个匿名内部类，每个常量都可以定义自己的eval
 * 方法
 * <p>
 * 类型安全枚举模式的可扩展变形与可序列化的兼容，每个子类必须分配自己的序数，并且提供自己的readResolve方法
 */
public abstract class Operation2 {
    private transient String name;

    protected Operation2(String name) {
        this.name = name;
    }

    protected Operation2() {
    }

    @Override
    public String toString() {
        return this.name;
    }

    protected abstract double eval(double x, double y);

    public static Operation2 PLUS = new Operation2("+") {
        @Override
        protected double eval(double x, double y) {
            return x + y;
        }
    };

    public static Operation2 MINUS = new Operation2("-") {
        @Override
        protected double eval(double x, double y) {
            return x - y;
        }
    };

    public static Operation2 TIMES = new Operation2("*") {
        @Override
        protected double eval(double x, double y) {
            return x * y;
        }
    };

    public static Operation2 DIVIDED_BY = new Operation2("/") {
        @Override
        protected double eval(double x, double y) {
            return x / y;
        }
    };

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * Prevent subclass from overriding Object.equals
     *
     * @param that
     * @return
     */
    @Override
    public final boolean equals(Object that) {
        return super.equals(that);
    }

    /**
     * The 4 declarations below are necessary for serialization
     */
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final Operation2[] VALUES = {PLUS, MINUS, TIMES, DIVIDED_BY};

    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }

}
