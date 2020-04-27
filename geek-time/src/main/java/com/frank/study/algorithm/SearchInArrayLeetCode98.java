package com.frank.study.algorithm;

/**
 * @ClassName: SearchInArrayLeetCode98
 * @Description:
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/4/27 9:08
 * @Version: 1.0
 */
public class SearchInArrayLeetCode98 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = (right-left)/2;
        while (true){
            if(nums[left] == target){
                return left;
            }
            if(nums[mid] == target){
                return mid;
            }
            if(nums[right] == target){
                return right;
            }
            if(left == right || left == mid || right == mid){
                break;
            }
            if(nums[left] > nums[mid]){
                if(target >nums[left]){
                    left = mid;
                }else{
                    if(target > nums[mid]){
                        left = mid;
                    }else{
                        right = mid;
                    }
                }
            }else{
                if(target < nums[mid] && target > nums[left]){
                    right = mid;
                }else{
                   left = mid;
                }
            }
            mid = left+(right-left)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,3));

        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(search(nums2,0));
        int[] nums3 = {4,5,6,7,0,1,2};
        System.out.println(search(nums3,1));

        int[] nums4 = {4,5,6,7,0,1,2};
        System.out.println(search(nums4,5));
        int[] nums5 = {4,5,6,7,0,1,2};
        System.out.println(search(nums5,6));
        int[] nums6 = {5,1,2,3,4};
        System.out.println(search(nums6,1));
    }
}
