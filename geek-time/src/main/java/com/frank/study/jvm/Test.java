package com.frank.study.jvm;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/5 11:12
 * @Version: 1.0
 */
public class Test {
    int a;

    public void foo() {
        int b = 0;
        System.out.println(b);
    }

    public static void main(String[] args) {
        A a = new B();
        B[] arr = new B[10];
        Test test = new Test();
        System.out.println(test.a);
    }
}
