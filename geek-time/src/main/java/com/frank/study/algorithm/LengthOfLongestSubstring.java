package com.frank.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LengthOfLongestSubstring
 * @Description:
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: 菜包子（孙中伟）
 * @Date: 2020/5/7 9:49
 * @Version: 1.0
 */
public class LengthOfLongestSubstring {

    /**
     * 通过滑动窗口的方式来解决该问题
     * @param s
     * @return
     */
    public static Integer solution(String s){
        if(s == null){
            return 0;
        }
        int r1 = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c),start);
            }
            map.put(c,end+1);
            r1 = Math.max(r1,end-start+1);
        }
        return r1;
    }


    public static void main(String[] args) {
        System.out.println(solution("pwwkew"));
        System.out.println(solution("dvdf"));
        System.out.println(solution("aab"));
        System.out.println(solution("bbbbbbbb"));
        System.out.println(solution("abcabcbb"));
    }
}
