package com.frank.study.algorithm;

/**
 * @ClassName: Queue
 * @Description: TODO
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/28 20:03
 * @Version: 1.0
 */
public interface Queue<T> {

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 大小
     * @return
     */
    int size();

    /**
     * 入队
     * @param t
     */
    boolean enqueue(T t);

    /**
     * 出队
     * @return
     */
    T dequeue();
}