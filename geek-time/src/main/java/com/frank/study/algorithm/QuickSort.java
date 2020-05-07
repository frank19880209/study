package com.frank.study.algorithm;

import java.util.Arrays;

/**
 * @ClassName: QuickSort
 * @Description: TODO
 * @Author: frank
 * @Date: 2020/5/2 8:02
 * @Version: 1.0
 */
public class QuickSort {

    public static void sort(int[] arr,int left,int right){
        if(arr == null || left > right){
            return;
        }
        int baseNum = arr[left];
        int i = left;
        int j = right;
        while (i<j){
            while (baseNum <= arr[j] && i < j){
                j--;
            }
            while (baseNum >= arr[i] && i < j){
                i++;
            }
            if(i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //基准数据进行交换
        arr[left] = arr[i];
        arr[i] = baseNum;
        sort(arr,left,j-1);
        sort(arr,j+1,right);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,6,7,1,0,-4,-8,67,1,11,-10};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
