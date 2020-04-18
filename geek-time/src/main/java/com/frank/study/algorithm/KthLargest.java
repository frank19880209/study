package com.frank.study.algorithm;


import java.util.PriorityQueue;

/**
 * @ClassName: KthLargest
 * @Description:
 * 703. 数据流中的第K大元素,
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/17 13:32
 * @Version: 1.0
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private final Integer MAX;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        MAX = k;
        for (int num : nums) {
            this.add(num);
        }
    }

    public int add(int val) {
        if(priorityQueue.size() < MAX){
            priorityQueue.offer(val);
        }else{
            if(priorityQueue.peek()<val){
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
