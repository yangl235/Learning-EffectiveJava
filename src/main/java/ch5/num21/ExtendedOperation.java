package ch5.num21;

import java.io.ObjectStreamException;

public class ExtendedOperation extends Operation2 {

    ExtendedOperation(String name) {
        super(name);
    }

    public static Operation2 LOG = new Operation2("log") {
        @Override
        protected double eval(double x, double y) {
            return Math.log(y) / Math.log(x);
        }
    };

    public static Operation2 EXP = new Operation2("exp") {
        @Override
        protected double eval(double x, double y) {
            return Math.pow(x, y);
        }
    };

    @Override
    protected double eval(double x, double y) {
        return 0;
    }

    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final Operation2[] VALUES = {LOG, EXP};

    @Override
    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];
    }
}
