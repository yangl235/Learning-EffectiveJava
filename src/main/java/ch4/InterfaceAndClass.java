package ch4;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InterfaceAndClass {
    /**
     * 1.通常情况下，共有类应该尽可能地减少共有的域，除非为静态final类型,一般来说，这些域由大写字母组成，
     * 单词之间用下划线隔开，这些域要么为原语类型，要么是指向非可变对象的引用，如果final与包含一个指向
     * 可变对象的引用，代码会很不安全.注意：具有公有的静态final数组域几乎总是错误的
     */

    //存在安全漏洞，用户可以修改values数组的值
    private static final Type[] values = {};

    //可以使用私有数组以及一个公有的非可变列表
    private static final Type[] PRIVATE_VALUES = {};
    public static final List VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    //如果要求编译时的类型安全性，并损失一点性能，可以吧公有的数组域替换成一个公有的方法，返回私有数组的一份拷贝
    public static final Type[] values() {
        return (Type[]) PRIVATE_VALUES.clone();
    }
    


}
