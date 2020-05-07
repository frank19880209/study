package com.frank.study.algorithm;

import java.util.Arrays;

/**
 * @ClassName: ArrayQueue
 * @Description: 用数组实现的队列叫作顺序队列
 * @Author: frank
 * @Date: 2020/4/28 20:06
 * @Version: 1.0
 */
public class ArrayQueue<T> implements Queue<T> {

    private Integer capacity;

    private Object[] array;

    private int header = 0;

    private int tail = 0;

    private volatile boolean isCopying = false;

    /**
     * 默认容量
     */
    private static final Integer DEFAULT_CAPACITY = 10;

    public ArrayQueue(Integer capacity){
        if(capacity == null || capacity <1){
            this.capacity = DEFAULT_CAPACITY;
        }else{
            this.capacity = capacity;
        }
        array = new Object[this.capacity.intValue()];
    }

    @Override
    public boolean isEmpty() {
        return this.tail-this.header == 0;
    }

    @Override
    public int size() {
        return this.tail-this.header;
    }

    @Override
    public boolean enqueue(T t) {
        while (this.isCopying){ }
        if(this.tail-this.header >= capacity){
           return false;
        }
        if(tail == capacity-1){
            this.isCopying = true;
            Object[] newArr = Arrays.copyOf(this.array,this.tail-this.header);
            this.array = newArr;
            this.isCopying = false;
        }
        this.array[tail++] = t;
        return true;
    }

    @Override
    public T dequeue() {
        while (this.isCopying){ }
        if(header == tail){
            return null;
        }
        return (T) this.array[header++];
    }
}
