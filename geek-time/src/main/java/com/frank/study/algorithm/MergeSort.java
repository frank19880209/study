package com.frank.study.algorithm;

import java.util.Arrays;

/**
 * @ClassName: MergeSort
 * @Description: 归并排序
 * @Author: frank
 * @Date: 2020/4/29 17:45
 * @Version: 1.0
 */
public class MergeSort {


    /**
     * 归并排序法
     * @param arr
     * @return
     */
    public static void sort(int[] arr,int left,int right){
        if(arr==null || left >= right) {
            return ;
        }
        int middle = (right+left)/2;
        sort(arr,left,middle);
        sort(arr,middle+1,right);
        merge(arr,left,right,middle);
    }

    public static void merge(int[] arr,int left,int right,int middle){
        int[] temp = new int[arr.length];
        int i = left;//左序列指针
        int j = middle+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=middle && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=middle){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,3,6,7,1,0,-4,-8,67,1,11,-10};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
