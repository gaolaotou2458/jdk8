package com.higer.jdk8.Predicate;

import java.util.function.Predicate;


/**
 * 用于判断，返回boolean值
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = p -> p.length() > 5;
        boolean test = predicate.test("123456");
        System.out.println(test);
    }
}
