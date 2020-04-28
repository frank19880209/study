package com.frank.study.algorithm;

/**
 * @ClassName: CircleQueue
 * @Description: TODO
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/28 20:39
 * @Version: 1.0
 */
public class CircleQueue<T> implements Queue<T> {

    private Integer capacity;

    private Object[] array;

    private int header = 0;

    private int tail = 0;


    /**
     * 默认容量
     */
    private static final Integer DEFAULT_CAPACITY = 10;

    public CircleQueue(Integer capacity){
        if(capacity == null || capacity <1){
            this.capacity = DEFAULT_CAPACITY;
        }else{
            this.capacity = capacity;
        }
        array = new Object[this.capacity.intValue()];
    }

    @Override
    public boolean isEmpty() {
        return header == tail;
    }

    @Override
    public int size() {
        return Math.abs(header-tail);
    }

    @Override
    public boolean enqueue(T t) {
        if ((tail + 1) % capacity == header) {
            return false;
        }
        array[tail] = t;
        tail = (tail + 1) % capacity;
        return true;
    }

    @Override
    public T dequeue() {
        if(header == tail){
            return null;
        }
        Object ret = array[header];
        header = (header + 1) % capacity;
        return (T) ret;
    }
}
