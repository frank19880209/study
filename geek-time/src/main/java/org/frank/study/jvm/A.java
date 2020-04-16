package org.frank.study.jvm;

/**
 * @ClassName: A
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/5 11:10
 * @Version: 1.0
 */
public class A {
    static {
        System.out.println("A init");
    }
    public A() {
        System.out.println("A Instance");
    }
}
