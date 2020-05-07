package com.frank.study.aviator;

import com.google.common.collect.ImmutableMap;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.Map;

/**
 * @ClassName: AviatorTest
 * @Description: TODO
 * @Author: frank
 * @Date: 2020/4/17 5:39
 * @Version: 1.0
 */
public class AviatorTest {

    public static void main(String[] args) {
        // 表达式
        String express = "x*x+y*y";

        Expression expression = AviatorEvaluator.compile(express);

        // 表达式中 x的值设置为 10, y的值设置为5
        Map<String, Object> params = ImmutableMap.of("x", 10, "y", 5);

        Object result = expression.execute(params);

        System.out.println("result: "+ result);
    }
}
