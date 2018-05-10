package ch5.num21;

/**
 * 外部调用Operation时，以Operation常量作为参数，Operation类本身是一个抽象类，只包含
 * 一个包级私有方法eval(),针对每个常量都定义一个匿名内部类，每个常量都可以定义自己的eval
 * 方法
 */
public abstract class Operation {
    private final String name;

    Operation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    abstract double eval(double x, double y);

    public static final Operation PLUS = new Operation("+") {
        @Override
        double eval(double x, double y) {
            return x + y;
        }
    };

    public static final Operation MINUS = new Operation("-") {
        @Override
        double eval(double x, double y) {
            return x - y;
        }
    };

    public static final Operation TIMES = new Operation("*") {
        @Override
        double eval(double x, double y) {
            return x * y;
        }
    };

    public static final Operation DIVIDED_BY = new Operation("/") {
        @Override
        double eval(double x, double y) {
            return x / y;
        }
    };

}
