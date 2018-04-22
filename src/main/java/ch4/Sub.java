package ch4;

import java.util.Date;

public class Sub extends Super {
    private final Date date;//

    public Sub() {
        date = new Date();
    }

    //重写Super.m()方法
    @Override
    public void m() {
        System.out.println(date);
    }

    public static void main(String [] args) {
        Sub s = new Sub();
        s.m();
    }
}
