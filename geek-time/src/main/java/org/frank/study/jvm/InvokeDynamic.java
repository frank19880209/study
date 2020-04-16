package org.frank.study.jvm;

/**
 * @ClassName: InvokeDynamic
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/11 20:54
 * @Version: 1.0
 */
public class InvokeDynamic {
    public static void main(String[] args) {
        Runnable r = ()->{
            System.out.println("hello, lambda");
        };
        r.run();
        int i = 0;
        i = ++i + i++ + i++ + i++;
        System.out.println("i=" + i);
    }
}
