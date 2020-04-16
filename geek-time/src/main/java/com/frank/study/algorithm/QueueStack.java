package com.frank.study.algorithm;

import com.frank.study.jvm.B;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: QueueStack
 * @Description: TODO
 * @Author: 孙中伟
 * @Date: 2020/4/16 21:23
 * @Version: 1.0
 */
public class QueueStack {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    private static Boolean checkBrackets(String s){
        if(s == null || s.trim().length() == 0){
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        Map<Character,Character> bracketMap = new HashMap(){{put(')','(');put(']','[');put('}','{');}};
        Stack<Character> stack = new Stack<>();
        char[] sarr = s.toCharArray();
        for (int i = 0; i < sarr.length; i++) {
            if(bracketMap.containsKey(sarr[i]) && !stack.empty() && bracketMap.get(sarr[i]).charValue() == stack.pop()){
                continue;
            }else{
                stack.push(sarr[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
       testBrackets();
    }

    private static void testBrackets(){
        System.out.println(checkBrackets("()[]{}"));
        System.out.println(checkBrackets("()[]{}]"));
        System.out.println(checkBrackets("({)[]{}]"));
    }
}
