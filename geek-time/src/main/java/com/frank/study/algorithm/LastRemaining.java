package com.frank.study.algorithm;

import java.util.*;

/**
 * @ClassName: LastRemaining
 * @Description:
 * 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * @Author: 孙中伟
 * @Date: 2020/3/30 17:46
 * @Version: 1.0
 */
public class LastRemaining {

    public static Integer lastNum(int n,int m){
        if(m == 1){
            return n-1;
        }
        if(n%m == 0){
            return 0;
        }
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        List<Integer> list = Arrays.asList(data);
        int count = 0;
        int length = n;
        int c = 0;
        while (length > 1){
            if(c>n-1){
                c = 0;
            }
            if(data[c] > -1){
                count++;
            }
            if(count == m){
              data[c] = -1;
              length --;
              count = 0;
            }
            c++;
        }
        for (Integer datum : data) {
            if(datum > -1){
                return datum;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lastNum(5,3));
        System.out.println(lastNum(10,17));
        System.out.println(lastNum(70866,116922));
    }

}
