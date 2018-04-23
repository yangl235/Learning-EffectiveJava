package ch4;

/**
 * 如果成员类的每个实例都需要一个指向其外围实例的引用，则把成员类做成非静态的，否则做成静态的
 */
public class Calculator {
    public static abstract class Operation {
        private final String name;

        Operation(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        /**
         * Perform arithmetic op represenred by this constant
         *
         * @param x
         * @param y
         * @return
         */
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

        public static Operation DIVIDE = new Operation("/") {
            @Override
            double eval(double x, double y) {
                return x / y;
            }
        };

    }

    /**
     * Return the result of the specified calculation
     *
     * @param x
     * @param op
     * @param y
     * @return
     */
    public double caculate(double x, Operation op, double y) {
        return op.eval(x, y);
    }
}
