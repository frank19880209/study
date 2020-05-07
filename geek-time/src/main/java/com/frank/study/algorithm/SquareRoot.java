package com.frank.study.algorithm;

/**
 * @ClassName: SquareRoot
 * @Description: 求一个正数的平方根
 * @Author: frank
 * @Date: 2020/5/2 13:36
 * @Version: 1.0
 */
public class SquareRoot {

    public static double squart(int n) {
        if (n < 2) {
            return n;
        }
        double l = 1;
        double r = n;
        double res = 0;
        while (l <= r){
            double mid = (l+r)/2;
            if(mid >= n/mid && mid*mid < n+0.0000001){
                res = mid;
            }else if(mid > (n/mid)+0.0000001){
                r = mid-0.25;
            }else{
                l = mid +0.25;
                res = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(squart(2147395599));
        System.out.println(System.currentTimeMillis()-s);
    }
}
