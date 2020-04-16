package org.frank.study.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @ClassName: Foo
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/10 17:52
 * @Version: 1.0
 */
public class Foo {
    public void print(String s) {
        System.out.println("hello, " + s);
    }

    public static void main(String[] args) throws Throwable {
        Foo foo = new Foo();
        MethodType methodType = MethodType.methodType(void.class,String.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Foo.class,"print",methodType);
        methodHandle.invokeExact(foo,"world");
    }
}
