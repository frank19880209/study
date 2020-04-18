package com.frank.study.algorithm;

/**
 * @ClassName: MaxSlidingWindow
 * @Description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * @Author: 孙中伟
 * @Date: 2020/4/18 9:03
 * @Version: 1.0
 */
public class MaxSlidingWindow {

    /**
     * 思路：
     * 1，首先，计算出第一个窗口的最大值windowMaxVal以及最大值对应的下标windowMaxIndex；
     * 2，第二步，数组从i(i初始值为k)下标开始遍历数组：
     *          A,如果windowMaxIndex在窗口范围内，并且windowMaxVal>下标为i的数字，则直接范围；
     *          B,否则再次求出最大值与最大值的下标
     * 3，算法复杂度为O（n）
     * @param nums
     * @param k
     * @return
     */
    public static int[] MaxSlidingWindow(int[] nums,int k){
        if(nums == null || nums.length == 0 || k <1 || k > nums.length){
            return null;
        }
        if(nums.length == 1){
            return nums;
        }
        int windowMaxVal = nums[0];
        int windowMaxIndex = 0;
        int[] result = new int[nums.length - k+1];
        for (int i = 1; i < k; i++) {
            if(windowMaxVal < nums[i]){
                windowMaxVal = nums[i];
                windowMaxIndex = i;
            }
        }
        result[0] = windowMaxVal;
        for (int i = k; i < nums.length; i++) {
            if(windowMaxIndex >= i-k+1 && windowMaxVal >= nums[i]){
                result[i-k+1] = windowMaxVal;
            }else{
                windowMaxIndex = i-k+1;
                windowMaxVal = nums[windowMaxIndex];
                for (int j = i-k+2 ; j <=i ; j++) {
                    if(windowMaxVal < nums[j]){
                        windowMaxVal = nums[j];
                        windowMaxIndex = j;
                    }
                }
                result[i-k+1] = windowMaxVal;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        printArray(MaxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3));
        printArray(MaxSlidingWindow(new int[]{7,2,4},2));
        printArray(MaxSlidingWindow(new int[]{1},1));
    }


    public static void printArray(int[] nums){
        if(nums != null){
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]+",");
            }
            System.out.println("");
        }
    }




}
