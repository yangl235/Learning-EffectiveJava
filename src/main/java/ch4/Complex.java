package ch4;

/**
 * 非可变类实现实例
 * 方法1：使用final class来实现
 * 方法2：使所有的构造函数都是私有的，或者包级私有的，增加公有的静态工厂来代替公有的构造函数
 */

public final class Complex {
    private float re = 0;
    private float im = 0;

    public Complex(float re, float im) {
        this.re = re;
        this.im = im;
    }

    //Accessors with no correspinding mutator;
    public float realPart() {
        return re;
    }

    public float imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex substract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public Complex divide(Complex c) {
        float tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex)) {
            return false;
        }
        Complex c = (Complex) o;
        return (Float.floatToIntBits(re) == Float.floatToIntBits(c.re) &&
                Float.floatToIntBits(im) == Float.floatToIntBits(c.im));
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + ")";
    }


}
