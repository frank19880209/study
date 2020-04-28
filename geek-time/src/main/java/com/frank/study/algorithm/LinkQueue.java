package com.frank.study.algorithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: LinkQueue
 * @Description: TODO
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/28 20:42
 * @Version: 1.0
 */
public class LinkQueue<T> implements Queue<T>{

    private AtomicInteger count = new AtomicInteger(0);

    private Node header = null;
    private Node tail = null;

    @Override
    public boolean isEmpty() {
        return count.get() == 0;
    }

    @Override
    public int size() {
        return count.get();
    }

    @Override
    public boolean enqueue(T t) {
        Node node = new Node(t);
        if(header == null){
            header = node;
            tail = header;
        }else{
            tail.setNext(node);
            Node tNode = tail;
            tail = tNode.getNext();
        }
        count.incrementAndGet();
        return true;
    }

    @Override
    public T dequeue() {
        if(header == null){
            return null;
        }
        Node next = header.getNext();
        Object data = header.getData();
        header = next;
        count.decrementAndGet();
        return (T) data;
    }

    private static class Node{
        private Object data;
        private Node next;

        public Node(Object data){
            this.data = data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
