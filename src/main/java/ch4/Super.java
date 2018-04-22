package ch4;

public class Super {
    //Broken - 构造函数调用了可能被重写的方法
    public Super() {
        m();
        System.out.println("Super Constructor is called");
    }


    public void m() {
        System.out.println("m() is called in Super");
    }
}
