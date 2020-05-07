package com.frank.study.algorithm;

/**
 * @ClassName: QueueTest
 * @Description: TODO
 * @Author: frank
 * @Date: 2020/4/28 21:11
 * @Version: 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> myArrayQueue = new ArrayQueue<>(20);
        myArrayQueue.enqueue(1);
        myArrayQueue.enqueue(2);
        myArrayQueue.enqueue(3);
        System.out.println(myArrayQueue.dequeue());
        System.out.println(myArrayQueue.dequeue());
        System.out.println(myArrayQueue.dequeue());
        System.out.println(myArrayQueue.dequeue());

        Queue<Integer> myLinkQueue = new LinkQueue<>();
        myLinkQueue.enqueue(1);
        myLinkQueue.enqueue(2);
        myLinkQueue.enqueue(3);
        System.out.println(myLinkQueue.dequeue());
        System.out.println(myLinkQueue.dequeue());
        System.out.println(myLinkQueue.dequeue());
        System.out.println(myLinkQueue.dequeue());

        Queue<Integer> cirQueue = new CircleQueue<>(10);
        cirQueue.enqueue(1);
        cirQueue.enqueue(2);
        cirQueue.enqueue(3);
        cirQueue.enqueue(4);
        cirQueue.enqueue(5);
        cirQueue.enqueue(6);
        cirQueue.enqueue(7);
        cirQueue.enqueue(8);
        cirQueue.enqueue(9);
        System.out.println(cirQueue.dequeue());
        cirQueue.enqueue(10);
        System.out.println(cirQueue.dequeue());
        System.out.println(cirQueue.dequeue());
        System.out.println(cirQueue.dequeue());
        System.out.println(cirQueue.dequeue());
        System.out.println(cirQueue.dequeue());
    }
}
