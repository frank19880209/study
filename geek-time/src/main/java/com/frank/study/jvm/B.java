package com.frank.study.jvm;

/**
 * @ClassName: B
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/5 11:12
 * @Version: 1.0
 */
public class B extends A {
    static {
        System.out.println("B init");
    }
    public B() {
        System.out.println("B Instance");
    }
}
